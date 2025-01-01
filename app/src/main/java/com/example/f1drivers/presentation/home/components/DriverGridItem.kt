package com.example.f1drivers.presentation.home.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.f1drivers.domain.model.driver.Driver
import kotlin.math.PI
import kotlin.math.sin


@Composable
fun DriverGridItem(
    driver: Driver,
    onItemClick: (Driver) -> Unit,
    modifier: Modifier = Modifier
) {
    var isPressed by remember { mutableStateOf(false) }
    
    val infiniteTransition = rememberInfiniteTransition(label = "float")
    val float by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float"
    )
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.92f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale"
    )

    val teamColors = getTeamColors(driver.team)
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            teamColors.first,
            teamColors.second
        )
    )

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            teamColors.first.copy(alpha = 0.15f),
            teamColors.second.copy(alpha = 0.3f),
            teamColors.first.copy(alpha = 0.15f)
        )
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.8f)
            .scale(scale)
            .graphicsLayer {
                translationY = sin(float * 2 * PI.toFloat()) * 3f
            }
    ) {
        Card(
            modifier = Modifier
                .matchParentSize()
                .offset(y = 4.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = teamColors.first.copy(alpha = 0.3f)
            )
        ) { }

        // Main Card
        Card(
            modifier = Modifier
                .matchParentSize()
                .clickable { 
                    onItemClick(driver)
                    isPressed = !isPressed 
                },
            shape = RoundedCornerShape(32.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.95f)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundGradient)
            ) {
                // Decorative Elements
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.radialGradient(
                                colors = listOf(
                                    teamColors.second.copy(alpha = 0.1f),
                                    teamColors.first.copy(alpha = 0.05f),
                                    Color.Transparent
                                )
                            )
                        )
                )

                // Content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        // Driver Image with Border
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .border(
                                    width = 3.dp,
                                    brush = gradientBrush,
                                    shape = CircleShape
                                )
                                .padding(4.dp)
                        ) {
                            AsyncImage(
                                model = driver.imageUrl,
                                contentDescription = "${driver.firstName} ${driver.lastName}",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.TopCenter
                            )
                        }

                        Surface(
                            shape = CircleShape,
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(8.dp)
                                .shadow(8.dp, CircleShape)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(gradientBrush)
                                    .padding(horizontal = 12.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = "#${driver.number}",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Surface(
                        color = Color.White.copy(alpha = 0.8f),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "${driver.firstName}\n${driver.lastName}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier.shadow(4.dp, RoundedCornerShape(24.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .background(gradientBrush)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = driver.team,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
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