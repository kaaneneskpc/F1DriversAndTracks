package com.example.f1drivers.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun GradientBackground(
    content: @Composable BoxScope.() -> Unit
) {
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
            .systemBarsPadding()
    ) {
        content()
    }
} 