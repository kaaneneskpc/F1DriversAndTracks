package com.example.f1drivers.presentation.circuits

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.f1drivers.data.local.CircuitsData
import com.example.f1drivers.presentation.circuits.components.CircuitListItem

@Composable
fun CircuitsScreen(
    onCircuitClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "2024 F1 Race Calendar",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 16.dp, top = 16.dp)
            )
        }
        
        items(CircuitsData.circuits) { circuit ->
            CircuitListItem(
                circuit = circuit,
                onItemClick = { onCircuitClick(it.id) }
            )
        }
    }
} 