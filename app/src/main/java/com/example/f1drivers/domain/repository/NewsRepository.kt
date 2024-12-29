package com.example.f1drivers.domain.repository

import com.example.f1drivers.domain.model.News
import com.example.f1drivers.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getF1News(): Flow<Resource<List<News>>>
} 