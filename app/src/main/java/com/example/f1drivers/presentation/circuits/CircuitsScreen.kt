package com.example.f1drivers.presentation.circuits

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.f1drivers.data.local.CircuitsData
import com.example.f1drivers.presentation.circuits.components.CircuitListItem
import com.example.f1drivers.presentation.common.GradientBackground

@Composable
fun CircuitsScreen(
    onCircuitClick: (Int) -> Unit
) {
    GradientBackground {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column {
                    Text(
                        text = "2024 F1",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Race Calendar",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
            
            items(CircuitsData.circuits) { circuit ->
                CircuitListItem(
                    circuit = circuit,
                    onItemClick = { onCircuitClick(it.id) }
                )
            }
        }
    }
} 