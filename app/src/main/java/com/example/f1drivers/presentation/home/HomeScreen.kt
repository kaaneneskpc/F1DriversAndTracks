package com.example.f1drivers.presentation.home

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.f1drivers.presentation.common.GradientBackground
import com.example.f1drivers.presentation.home.components.DriverGridItem
import com.example.f1drivers.presentation.favorites.FavoritesViewModel
import com.example.f1drivers.presentation.home.components.DriverListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    onDriverClick: (Int) -> Unit
) {
    val driversState by viewModel.driversState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val viewType by viewModel.viewType.collectAsState()
    val favoriteDrivers by favoritesViewModel.favoriteDrivers.collectAsState()

    GradientBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            topBar = {
                TopAppBar(
                    modifier = Modifier.statusBarsPadding(),
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "F1 2024 Drivers",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 16.dp)
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { viewModel.toggleViewType() }) {
                            Icon(
                                imageVector = if (viewType == ViewType.LIST) 
                                    Icons.Default.GridView else Icons.AutoMirrored.Filled.List,
                                contentDescription = "Toggle view",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(28.dp),
                    color = Color.White.copy(alpha = 0.9f),
                    shadowElevation = 8.dp
                ) {
                    TextField(
                        value = searchQuery,
                        onValueChange = { viewModel.updateSearchQuery(it) },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { 
                            Text(
                                "Search drivers...",
                                color = Color.Gray
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color(0xFF3949AB)
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        singleLine = true
                    )
                }

                when (driversState) {
                    is DriversState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = Color.White)
                        }
                    }
                    is DriversState.Success -> {
                        val drivers = (driversState as DriversState.Success).drivers
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn() + slideInVertically(),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            if (viewType == ViewType.GRID) {
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(2),
                                    contentPadding = PaddingValues(
                                        start = 16.dp,
                                        end = 16.dp,
                                        top = 16.dp,
                                        bottom = 100.dp
                                    ),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    items(drivers) { driver ->
                                        DriverGridItem(
                                            driver = driver,
                                            onItemClick = { onDriverClick(it.id) }
                                        )
                                    }
                                }
                            } else {
                                LazyColumn(
                                    contentPadding = PaddingValues(
                                        start = 16.dp,
                                        end = 16.dp,
                                        top = 16.dp,
                                        bottom = 100.dp
                                    ),
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    items(drivers) { driver ->
                                        DriverListItem(
                                            driver = driver,
                                            onClick = { onDriverClick(driver.id) },
                                            isFavorite = favoriteDrivers.contains(driver.id),
                                            onFavoriteClick = { favoritesViewModel.toggleFavorite(driver.id) }
                                        )
                                    }
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
                                    text = (driversState as DriversState.Error).message,
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
}


@Composable
fun getTeamColors(team: String): Pair<Color, Color> {
    return when (team.lowercase()) {
        "red bull racing" -> Pair(Color(0xFF1E41FF), Color(0xFFED1E24))
        "ferrari" -> Pair(Color(0xFFDC0000), Color(0xFFFFBA08))
        "mercedes" -> Pair(Color(0xFF000000), Color(0xFF00D2BE))
        "mclaren" -> Pair(Color(0xFFFF8700), Color(0xFF47C7FC))
        "aston martin" -> Pair(Color(0xFF006F62), Color(0xFF00594F))
        "alpine" -> Pair(Color(0xFF0090FF), Color(0xFFFF0000))
        "williams" -> Pair(Color(0xFF005AFF), Color(0xFF00A0DE))
        "rb" -> Pair(Color(0xFF2B4562), Color(0xFFFFFFFF))
        "kick sauber" -> Pair(Color(0xFF1B4D3E), Color(0xFF2ECC71))
        "haas f1 team" -> Pair(Color(0xFF242424), Color(0xFFB40000))
        else -> Pair(Color(0xFF1E1E1E), Color(0xFF454545))
    }
} 