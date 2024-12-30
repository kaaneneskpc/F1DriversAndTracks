package com.example.f1drivers.navigation

sealed class NavigationScreen(val route: String) {
    object Splash : NavigationScreen("splash")
    object Home : NavigationScreen("home")
    object News : NavigationScreen("news")
    object Circuits : NavigationScreen("circuits")
    object DriverDetail : NavigationScreen("driver_detail/{driverId}") {
        fun createRoute(driverId: Int) = "driver_detail/$driverId"
    }
    object CircuitDetail : NavigationScreen("circuit_detail/{circuitId}") {
        fun createRoute(circuitId: Int) = "circuit_detail/$circuitId"
    }
    object NewsDetail : NavigationScreen("news_detail/{newsUrl}") {
        fun createRoute(newsUrl: String) = "news_detail/${newsUrl}"
    }
} 