package com.example.f1drivers.domain.model

data class News(
    val title: String,
    val description: String?,
    val url: String,
    val imageUrl: String?,
    val publishedAt: String,
    val content: String?
) 