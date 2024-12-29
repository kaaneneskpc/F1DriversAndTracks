package com.example.f1drivers.di

import com.example.f1drivers.data.remote.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val NEWS_BASE_URL = "https://newsapi.org/"
    private const val NEWS_API_KEY = "7f220678fbb54fd3b77d98e236b9890e"

    @Provides
    @Singleton
    @Named("newsRetrofit")
    fun provideNewsRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(@Named("newsRetrofit") retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideApiKey(): String = NEWS_API_KEY
} 