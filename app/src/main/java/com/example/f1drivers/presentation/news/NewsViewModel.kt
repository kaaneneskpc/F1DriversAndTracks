package com.example.f1drivers.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1drivers.domain.model.News
import com.example.f1drivers.domain.repository.NewsRepository
import com.example.f1drivers.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _newsState = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsState: StateFlow<NewsState> = _newsState

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            newsRepository.getF1News().collect { result ->
                _newsState.value = when(result) {
                    is Resource.Success -> NewsState.Success(result.data ?: emptyList())
                    is Resource.Error -> NewsState.Error(result.message ?: "An unexpected error occurred")
                    is Resource.Loading -> NewsState.Loading
                }
            }
        }
    }
}

sealed class NewsState {
    object Loading : NewsState()
    data class Success(val news: List<News>) : NewsState()
    data class Error(val message: String) : NewsState()
} 