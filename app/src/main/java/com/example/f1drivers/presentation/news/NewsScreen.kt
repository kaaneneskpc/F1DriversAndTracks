package com.example.f1drivers.presentation.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.f1drivers.domain.model.News

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel(),
    onNewsClick: (String) -> Unit
) {
    val newsState by viewModel.newsState.collectAsState()

    when (val state = newsState) {
        is NewsState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is NewsState.Success -> {
            NewsList(
                news = state.news,
                onNewsClick = onNewsClick
            )
        }
        is NewsState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = state.message)
            }
        }
    }
}

@Composable
fun NewsList(
    news: List<News>,
    onNewsClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(news) { newsItem ->
            NewsCard(
                news = newsItem,
                onNewsClick = onNewsClick
            )
        }
    }
}

@Composable
fun NewsCard(
    news: News,
    onNewsClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onNewsClick(news.url) },
    ) {
        Column {
            news.imageUrl?.let { imageUrl ->
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = news.title,
                    style = MaterialTheme.typography.titleMedium
                )
                news.description?.let { description ->
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Text(
                    text = news.publishedAt,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
} 