package com.example.f1drivers.presentation.standings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.f1drivers.data.local.DriversData
import com.example.f1drivers.presentation.common.GradientBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverStandingsScreen(
    onBackClick: () -> Unit = {},
                    onDriverClick: (Int) -> Unit = {},
                onTeamClick: (Int) -> Unit = {},
                onRaceClick: (Int) -> Unit = {}
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Drivers", "Teams", "Winners")

    GradientBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "2025 Standings",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
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
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    containerColor = Color.White.copy(alpha = 0.9f),
                    contentColor = Color(0xFF1A237E)
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(
                                    text = title,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        )
                    }
                }
                when (selectedTabIndex) {
                    0 -> DriverStandingsContent(onDriverClick = onDriverClick)
                    1 -> TeamStandingsScreen(onTeamClick = onTeamClick)
                    2 -> WinnersScreen(onRaceClick = onRaceClick)
                }
            }
        }
    }
}

@Composable
private fun DriverStandingsContent(
    onDriverClick: (Int) -> Unit
) {
    val driversWithStandings = DriversData.drivers.values
        .filter { it.standingsPosition != null }
        .sortedBy { it.standingsPosition }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            StandingsHeader()
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(driversWithStandings) { driver ->
            StandingsRow(
                driver = driver,
                onClick = { onDriverClick(driver.id) }
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun StandingsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White.copy(alpha = 0.9f),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "POS",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.15f)
        )
        Text(
            text = "DRIVER",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.6f)
        )
        Text(
            text = "TEAM",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.25f)
        )
        Text(
            text = "PTS",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.2f),
            textAlign = androidx.compose.ui.text.style.TextAlign.End
        )
    }
}

@Composable
private fun StandingsRow(
    driver: com.example.f1drivers.domain.model.driver.Driver,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.9f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${driver.standingsPosition}",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = when (driver.standingsPosition) {
                    1 -> Color(0xFFFFD700)
                    2 -> Color(0xFFC0C0C0)
                    3 -> Color(0xFFCD7F32)
                    else -> Color(0xFF1A237E)
                },
                modifier = Modifier.weight(0.15f)
            )

            Row(
                modifier = Modifier.weight(0.6f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = driver.imageUrl,
                    contentDescription = "${driver.firstName} ${driver.lastName}",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 12.dp)
                )
                Column {
                    Text(
                        text = "${driver.firstName} ${driver.lastName}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A237E)
                    )
                    Text(
                        text = driver.nationality,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF303F9F)
                    )
                }
            }

            Text(
                text = driver.team,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF303F9F),
                modifier = Modifier.weight(0.25f)
            )

            Text(
                text = "${driver.standingsPoints}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E),
                modifier = Modifier.weight(0.2f),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )
        }
    }
} 