package com.example.f1drivers.presentation.standings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.f1drivers.data.local.AustraliaRaceData
import com.example.f1drivers.presentation.common.GradientBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RaceDetailScreen(
    raceId: Int,
    onBackClick: () -> Unit = {}
) {
    val raceResults = AustraliaRaceData.raceResults

    GradientBackground {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Australia Grand Prix 2025",
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    RaceResultHeader()
                    Spacer(modifier = Modifier.height(16.dp))
                }

                items(raceResults) { result ->
                    RaceResultRow(result = result)
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
private fun RaceResultHeader() {
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
            modifier = Modifier.weight(0.13f)
        )
        Text(
            text = "DRIVER",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.37f)
        )
        Text(
            text = "TEAM",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.20f)
        )
        Text(
            text = "LAPS",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.15f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "TIME",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.25f),
            textAlign = TextAlign.End
        )
        Text(
            text = "PTS",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.15f),
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun RaceResultRow(
    result: com.example.f1drivers.domain.model.race.RaceResult
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.9f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Position
            Text(
                text = result.position,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = when (result.position) {
                    "1" -> Color(0xFFFFD700) // Gold
                    "2" -> Color(0xFFC0C0C0) // Silver
                    "3" -> Color(0xFFCD7F32) // Bronze
                    else -> Color(0xFF1A237E)
                },
                modifier = Modifier.weight(0.1f)
            )

            // Driver Info
            Row(
                modifier = Modifier.weight(0.4f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = result.driverImageUrl,
                    contentDescription = result.driverName,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(end = 8.dp)
                )
                Column {
                    Text(
                        text = result.driverName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A237E)
                    )
                    Text(
                        text = "#${result.driverNumber}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF303F9F)
                    )
                }
            }

            // Team
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = result.teamImageUrl,
                    contentDescription = result.team,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = result.team,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF303F9F),
                    textAlign = TextAlign.Center
                )
            }

            // Laps
            Text(
                text = "${result.laps}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E),
                modifier = Modifier.weight(0.15f),
                textAlign = TextAlign.Center
            )

            // Time
            Text(
                text = result.time,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E),
                modifier = Modifier.weight(0.2f),
                textAlign = TextAlign.End
            )

            // Points
            Text(
                text = "${result.points}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E),
                modifier = Modifier.weight(0.1f),
                textAlign = TextAlign.End
            )
        }
    }
} 