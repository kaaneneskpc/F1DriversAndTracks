package com.example.f1drivers.presentation.home.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1drivers.domain.model.driver.Driver
import com.example.f1drivers.domain.repository.DriverRepository
import com.example.f1drivers.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriverDetailViewModel @Inject constructor(
    private val repository: DriverRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _driverState = MutableStateFlow<DriverDetailState>(DriverDetailState.Loading)
    val driverState: StateFlow<DriverDetailState> = _driverState

    init {
        savedStateHandle.get<Int>("driverId")?.let { driverId ->
            getDriver(driverId)
        }
    }

    private fun getDriver(id: Int) {
        viewModelScope.launch {
            repository.getDriverById(id).collect { result ->
                _driverState.value = when(result) {
                    is Resource.Success -> DriverDetailState.Success(result.data!!)
                    is Resource.Error -> DriverDetailState.Error(result.message ?: "An unexpected error occurred")
                    is Resource.Loading -> DriverDetailState.Loading
                }
            }
        }
    }
}

sealed class DriverDetailState {
    object Loading : DriverDetailState()
    data class Success(val driver: Driver) : DriverDetailState()
    data class Error(val message: String) : DriverDetailState()
} 