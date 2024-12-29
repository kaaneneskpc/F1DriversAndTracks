package com.example.f1drivers.presentation.circuits

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.f1drivers.data.local.CircuitsData
import com.example.f1drivers.presentation.circuits.components.CircuitListItem

@Composable
fun CircuitsScreen(
    onCircuitClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "F1 2024 Circuits",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )
        
        LazyColumn {
            items(CircuitsData.circuits) { circuit ->
                CircuitListItem(
                    circuit = circuit,
                    onItemClick = { onCircuitClick(it.id) }
                )
            }
        }
    }
} 