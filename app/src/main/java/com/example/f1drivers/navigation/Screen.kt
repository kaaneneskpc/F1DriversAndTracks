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
    data object News : Screen

    @Serializable
    data object Circuits : Screen

    @Serializable
    data object Favorites : Screen

    @Serializable
    data class DriverDetail(val driverId: Int) : Screen

    @Serializable
    data class CircuitDetail(val circuitId: Int) : Screen

    @Serializable
    data class NewsDetail(val newsUrl: String) : Screen

    companion object {
        fun getRoute(screen: Screen): String {
            return screen::class.qualifiedName.orEmpty()
        }

        fun shouldShowBottomBar(currentRoute: String?): Boolean {
            return when (currentRoute) {
                getRoute(Home), getRoute(News), getRoute(Circuits), getRoute(Favorites) -> true
                else -> false
            }
        }
    }


}
