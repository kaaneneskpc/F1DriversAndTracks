package com.example.f1drivers.presentation.favorites

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
    private val _favoriteDrivers = MutableStateFlow(loadFavorites())
    val favoriteDrivers: StateFlow<Set<Int>> = _favoriteDrivers

    private fun loadFavorites(): Set<Int> {
        return sharedPreferences.getStringSet("favorite_drivers", emptySet())
            ?.mapNotNull { it.toIntOrNull() }
            ?.toSet()
            ?: emptySet()
    }

    private fun saveFavorites(favorites: Set<Int>) {
        sharedPreferences.edit()
            .putStringSet("favorite_drivers", favorites.map { it.toString() }.toSet())
            .apply()
    }

    fun toggleFavorite(driverId: Int) {
        val currentFavorites = _favoriteDrivers.value.toMutableSet()
        if (currentFavorites.contains(driverId)) {
            currentFavorites.remove(driverId)
        } else {
            currentFavorites.add(driverId)
        }
        _favoriteDrivers.value = currentFavorites
        saveFavorites(currentFavorites)
    }
} 