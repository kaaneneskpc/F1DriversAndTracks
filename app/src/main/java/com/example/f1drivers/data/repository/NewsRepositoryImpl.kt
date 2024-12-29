package com.example.f1drivers.data.repository

import com.example.f1drivers.data.remote.NewsApi
import com.example.f1drivers.domain.model.News
import com.example.f1drivers.domain.repository.NewsRepository
import com.example.f1drivers.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val apiKey: String
) : NewsRepository {
    override fun getF1News(): Flow<Resource<List<News>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getF1News(apiKey = apiKey)
            val news = response.articles.map { article ->
                News(
                    title = article.title,
                    description = article.description,
                    url = article.url,
                    imageUrl = article.urlToImage,
                    publishedAt = article.publishedAt,
                    content = article.content
                )
            }
            emit(Resource.Success(news))
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "An error occurred: ${e.localizedMessage}",
                data = null
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server. Check your internet connection.",
                data = null
            ))
        }
    }
} 