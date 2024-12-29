package com.example.f1drivers.domain.repository

import com.example.f1drivers.domain.model.driver.Driver
import com.example.f1drivers.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface DriverRepository {
    fun getDrivers(): Flow<Resource<List<Driver>>>
    fun getDriverById(id: Int): Flow<Resource<Driver>>
} 