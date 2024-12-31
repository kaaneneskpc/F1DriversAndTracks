package com.example.f1drivers.presentation.home

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.f1drivers.domain.model.driver.Driver
import com.example.f1drivers.presentation.home.components.DriverGridItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onDriverClick: (Int) -> Unit
) {
    val driversState by viewModel.driversState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val viewType by viewModel.viewType.collectAsState()

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1A237E), // Koyu mavi
            Color(0xFF303F9F), // Orta mavi
            Color(0xFF3949AB)  // Açık mavi
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBackground)
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
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
                // Search Bar
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
                                    contentPadding = PaddingValues(16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    items(drivers) { driver ->
                                        DriverGridItem(
                                            driver = driver,
                                            onItemClick = { onDriverClick(driver.id) },
                                            onFavoriteClick = { /* Implement favorite functionality */ },
                                            isFavorite = false
                                        )
                                    }
                                }
                            } else {
                                LazyColumn(
                                    contentPadding = PaddingValues(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    items(drivers) { driver ->
                                        DriverListItem(
                                            driver = driver,
                                            onClick = { onDriverClick(driver.id) }
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
fun DriverListItem(
    driver: Driver,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val teamColors = getTeamColors(driver.team)
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            teamColors.first.copy(alpha = 0.2f),
            teamColors.second.copy(alpha = 0.3f)
        )
    )

    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.9f)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradientBrush)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(teamColors.first, teamColors.second)
                        )
                    ),
                    modifier = Modifier.size(80.dp)
                ) {
                    AsyncImage(
                        model = driver.imageUrl,
                        contentDescription = "${driver.firstName} ${driver.lastName}",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "${driver.firstName} ${driver.lastName}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = driver.team,
                        style = MaterialTheme.typography.bodyMedium,
                        color = teamColors.first
                    )
                }
                
                Surface(
                    shape = CircleShape,
                    color = teamColors.first.copy(alpha = 0.2f),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = "#${driver.number}",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = teamColors.first,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun getTeamColors(team: String): Pair<Color, Color> {
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