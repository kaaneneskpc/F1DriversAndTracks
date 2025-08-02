package com.example.f1drivers.navigation


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable



@OptIn(InternalSerializationApi::class)
sealed interface Screen {
    @Serializable
    data object Splash : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object Circuits : Screen

    @Serializable
    data object Favorites : Screen

    @Serializable
    data class DriverDetail(val driverId: Int) : Screen

    @Serializable
    data class CircuitDetail(val circuitId: Int) : Screen

    @Serializable
    data class RaceDetail(val raceId: Int) : Screen

    @Serializable
    data object Standings : Screen

    companion object {
        fun getRoute(screen: Screen): String {
            return screen::class.qualifiedName.orEmpty()
        }

        fun shouldShowBottomBar(currentRoute: String?): Boolean {
            return when (currentRoute) {
                getRoute(Home), getRoute(Circuits), getRoute(Favorites), getRoute(Standings) -> true
                else -> false
            }
        }
    }


}
