package com.example.f1drivers.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1drivers.domain.model.driver.Driver
import com.example.f1drivers.domain.repository.DriverRepository
import com.example.f1drivers.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ViewType {
    LIST,
    GRID
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val driverRepository: DriverRepository
) : ViewModel() {

    private val _driversState = MutableStateFlow<DriversState>(DriversState.Loading)
    val driversState = _driversState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _viewType = MutableStateFlow(ViewType.LIST)
    val viewType = _viewType.asStateFlow()

    private var allDrivers = listOf<Driver>()

    init {
        getDrivers()
    }

    private fun getDrivers() {
        viewModelScope.launch {
            driverRepository.getDrivers().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        allDrivers = result.data.orEmpty()
                        filterDrivers()
                    }
                    is Resource.Error -> {
                        _driversState.value = DriversState.Error(
                            result.message ?: "An unexpected error occurred"
                        )
                    }
                    is Resource.Loading -> {
                        _driversState.value = DriversState.Loading
                    }
                }
            }
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        filterDrivers()
    }

    private fun filterDrivers() {
        val query = _searchQuery.value.trim().lowercase()
        val filteredDrivers = if (query.isEmpty()) {
            allDrivers
        } else {
            allDrivers.filter { driver ->
                driver.firstName.lowercase().contains(query) ||
                driver.lastName.lowercase().contains(query) ||
                driver.team.lowercase().contains(query) ||
                driver.number.toString().contains(query)
            }
        }
        _driversState.value = DriversState.Success(filteredDrivers)
    }

    fun toggleViewType() {
        _viewType.value = if (_viewType.value == ViewType.LIST) ViewType.GRID else ViewType.LIST
    }
}

sealed class DriversState {
    object Loading : DriversState()
    data class Success(val drivers: List<Driver>) : DriversState()
    data class Error(val message: String) : DriversState()
} 