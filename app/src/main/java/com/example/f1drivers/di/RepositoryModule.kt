package com.example.f1drivers.di

import com.example.f1drivers.data.repository.DriverRepositoryImpl
import com.example.f1drivers.domain.repository.DriverRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDriverRepository(
        driverRepositoryImpl: DriverRepositoryImpl
    ): DriverRepository
} 