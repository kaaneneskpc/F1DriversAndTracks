package com.example.f1drivers.data.remote

import com.example.f1drivers.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything")
    suspend fun getF1News(
        @Query("q") query: String = "(Formula 1 OR Formula One OR F1) AND (racing OR driver OR championship OR grand prix OR qualifying OR race)",
        @Query("domains") domains: String = "formula1.com,motorsport.com,autosport.com,racefans.net,f1i.com",
        @Query("apiKey") apiKey: String,
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("pageSize") pageSize: Int = 50
    ): NewsResponse
} 