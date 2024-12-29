package com.example.f1drivers.data.repository

import com.example.f1drivers.data.local.DriversData
import com.example.f1drivers.domain.model.driver.Driver
import com.example.f1drivers.domain.repository.DriverRepository
import com.example.f1drivers.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DriverRepositoryImpl @Inject constructor(
) : DriverRepository {

    override fun getDrivers(): Flow<Resource<List<Driver>>> = flow {
        try {
            emit(Resource.Loading())
            // Directly return local data as we have all drivers
            emit(Resource.Success(DriversData.drivers.values.toList()))
        } catch (e: Exception) {
            emit(Resource.Error("Error loading drivers"))
        }
    }

    override fun getDriverById(id: Int): Flow<Resource<Driver>> = flow {
        try {
            emit(Resource.Loading())
            // Get driver directly from local data
            val localDriver = DriversData.getDriverById(id)
            if (localDriver != null) {
                emit(Resource.Success(localDriver))
            } else {
                emit(Resource.Error("Driver not found"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("Error loading driver"))
        }
    }
} 