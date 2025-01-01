package com.example.f1drivers.presentation.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.f1drivers.presentation.home.HomeViewModel
import com.example.f1drivers.presentation.home.DriversState
import com.example.f1drivers.presentation.common.GradientBackground
import com.example.f1drivers.presentation.home.components.DriverListItem

@Composable
fun FavoritesScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    onDriverClick: (Int) -> Unit
) {
    val driversState by homeViewModel.driversState.collectAsState()
    val favoriteDrivers by favoritesViewModel.favoriteDrivers.collectAsState()

    GradientBackground {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Favorite Drivers",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )

            when (val state = driversState) {
                is DriversState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Color.White)
                    }
                }
                is DriversState.Success -> {
                    val favoriteDriversList = state.drivers.filter { driver ->
                        favoriteDrivers.contains(driver.id)
                    }

                    if (favoriteDriversList.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White.copy(alpha = 0.9f)
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 4.dp
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp),
                                        tint = Color(0xFFFF1744)
                                    )
                                    
                                    Spacer(modifier = Modifier.height(16.dp))
                                    
                                    Text(
                                        text = "No Favorite Drivers Yet",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                    
                                    Spacer(modifier = Modifier.height(8.dp))
                                    
                                    Text(
                                        text = "Add drivers to your favorites by tapping the heart icon in list view",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    } else {
                        LazyColumn(
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(favoriteDriversList) { driver ->
                                DriverListItem(
                                    driver = driver,
                                    onClick = { onDriverClick(driver.id) },
                                    isFavorite = true,
                                    onFavoriteClick = { favoritesViewModel.toggleFavorite(driver.id) }
                                )
                            }
                        }
                    }
                }
                is DriversState.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            color = Color.White.copy(alpha = 0.9f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = state.message,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
} 