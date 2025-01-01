package com.example.f1drivers.presentation.circuits.detail

import Circuit
import RaceSchedule
import WeatherInfo
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.f1drivers.data.local.CircuitsData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircuitDetailScreen(
    circuitId: Int,
    onBackClick: () -> Unit
) {
    val circuit = CircuitsData.circuits.find { it.id == circuitId }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { 
                    Text(
                        text = "Circuit Details",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->
        if (circuit != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
            ) {
                CircuitDetailContent(
                    circuit = circuit,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Circuit not found",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
private fun CircuitDetailContent(
    circuit: Circuit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        CircuitHeader(circuit)
        Spacer(modifier = Modifier.height(24.dp))

        CircuitMap(circuit)
        Spacer(modifier = Modifier.height(24.dp))

        WeatherSection(circuit.weatherConditions)
        Spacer(modifier = Modifier.height(24.dp))

        RaceScheduleSection(circuit.raceSchedule)
        Spacer(modifier = Modifier.height(24.dp))

        CircuitCharacteristics(circuit)
        Spacer(modifier = Modifier.height(24.dp))

        TechnicalDetails(circuit)
        Spacer(modifier = Modifier.height(24.dp))

        PreviousWinners(circuit)
        Spacer(modifier = Modifier.height(24.dp))

        AboutCircuit(circuit)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun WeatherSection(weather: WeatherInfo) {
    SectionTitle("Weather Conditions")

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                WeatherItem(
                    icon = Icons.Default.Thermostat,
                    title = "Temperature",
                    value = weather.averageTemperature
                )
                WeatherItem(
                    icon = Icons.Default.WaterDrop,
                    title = "Rain Chance",
                    value = weather.chanceOfRain
                )
                WeatherItem(
                    icon = Icons.Default.Air,
                    title = "Wind",
                    value = weather.windSpeed
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                WeatherItem(
                    icon = Icons.Default.Opacity,
                    title = "Humidity",
                    value = weather.humidity
                )
                WeatherItem(
                    icon = Icons.Default.Cloud,
                    title = "Conditions",
                    value = weather.conditions
                )
            }
        }
    }
}

@Composable
private fun WeatherItem(
    icon: ImageVector,
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun RaceScheduleSection(schedule: RaceSchedule) {
    SectionTitle("Race Weekend Schedule")

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Race Day: ${schedule.raceDay}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            schedule.sessions.forEach { session ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = session.name,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = session.day,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Text(
                        text = session.time,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                if (session != schedule.sessions.last()) {
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

@Composable
private fun CircuitHeader(circuit: Circuit) {

    Text(
        text = circuit.name,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = circuit.country,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun CircuitMap(circuit: Circuit) {
    SectionTitle("Circuit Layout")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        AsyncImage(
            model = circuit.circuitMapUrl,
            contentDescription = "Circuit layout",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
private fun CircuitCharacteristics(circuit: Circuit) {
    SectionTitle("Circuit Characteristics")

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CharacteristicItem(
                    title = "Corners",
                    value = circuit.numberOfCorners.toString()
                )
                CharacteristicItem(
                    title = "DRS Zones",
                    value = circuit.numberOfDrsZones.toString()
                )
                CharacteristicItem(
                    title = "Race Distance",
                    value = circuit.raceDistance
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            circuit.characteristics.forEach { characteristic ->
                Text(
                    text = "• $characteristic",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun TechnicalDetails(circuit: Circuit) {
    SectionTitle("Technical Details")

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            CircuitInfoItem(title = "Track Length", value = circuit.length)
            CircuitInfoItem(title = "Race Laps", value = circuit.numberOfLaps.toString())
            CircuitInfoItem(title = "Lap Record", value = circuit.lapRecord)
            CircuitInfoItem(title = "Record Holder", value = circuit.lapRecordHolder)
            CircuitInfoItem(title = "First Grand Prix", value = circuit.firstGrandPrix.toString())
        }
    }
}

@Composable
private fun PreviousWinners(circuit: Circuit) {
    SectionTitle("Previous Winners")

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            circuit.previousWinners.forEach { winner ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = winner.year.toString(),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Column {
                        Text(
                            text = winner.driverName,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = winner.team,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                if (winner != circuit.previousWinners.last()) {
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

@Composable
private fun AboutCircuit(circuit: Circuit) {
    SectionTitle("About the Circuit")
    Text(
        text = circuit.description,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
private fun CharacteristicItem(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun CircuitInfoItem(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 16.dp)
    )
} 