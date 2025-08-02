package com.example.f1drivers.presentation.standings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.f1drivers.data.local.RacesData

@Composable
fun WinnersScreen(
    onRaceClick: (Int) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
            WinnersHeader()
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(RacesData.races) { race ->
            WinnerRow(
                race = race,
                onClick = { onRaceClick(race.id) }
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun WinnersHeader() {
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
            text = "RACE",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.4f)
        )
        Text(
            text = "WINNER",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.4f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "TIME",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E),
            modifier = Modifier.weight(0.2f),
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun WinnerRow(
    race: com.example.f1drivers.domain.model.race.Race,
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(0.3f)
                ) {
                    Text(
                        text = race.grandPrix,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A237E)
                    )
                    Text(
                        text = race.date,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF303F9F)
                    )
                }

                Column(
                    modifier = Modifier.weight(0.4f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = race.winnerImageUrl,
                            contentDescription = race.winner,
                            modifier = Modifier
                                .size(32.dp)
                                .padding(end = 8.dp)
                        )
                        Column {
                            Text(
                                text = race.winner,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1A237E)
                            )
                            Text(
                                text = race.winnerCode,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFF303F9F)
                            )
                        }
                    }
                    AsyncImage(
                        model = race.teamImageUrl,
                        contentDescription = race.winnerTeam,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(top = 4.dp)
                    )
                }

                Column(
                    modifier = Modifier.weight(0.3f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = race.time,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A237E),
                        textAlign = TextAlign.End
                    )
                    Text(
                        text = "${race.laps} laps",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF303F9F),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
} 