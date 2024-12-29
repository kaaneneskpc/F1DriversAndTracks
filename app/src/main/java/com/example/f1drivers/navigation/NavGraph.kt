package com.example.f1drivers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.f1drivers.presentation.circuits.CircuitsScreen
import com.example.f1drivers.presentation.circuits.detail.CircuitDetailScreen
import com.example.f1drivers.presentation.home.HomeScreen
import com.example.f1drivers.presentation.home.detail.DriverDetailScreen
import com.example.f1drivers.presentation.news.NewsScreen
import com.example.f1drivers.presentation.news.NewsWebViewScreen
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Home.route
    ) {
        composable(route = NavigationScreen.Home.route) {
            HomeScreen(
                onDriverClick = { driverId ->
                    navController.navigate(NavigationScreen.DriverDetail.createRoute(driverId))
                }
            )
        }
        composable(route = NavigationScreen.News.route) {
            NewsScreen(
                onNewsClick = { newsUrl ->
                    val encodedUrl = URLEncoder.encode(newsUrl, StandardCharsets.UTF_8.toString())
                    navController.navigate(NavigationScreen.NewsDetail.createRoute(encodedUrl))
                }
            )
        }
        composable(route = NavigationScreen.Circuits.route) {
            CircuitsScreen(
                onCircuitClick = { circuitId ->
                    navController.navigate(NavigationScreen.CircuitDetail.createRoute(circuitId))
                }
            )
        }
        composable(
            route = NavigationScreen.CircuitDetail.route,
            arguments = listOf(
                navArgument("circuitId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val circuitId = backStackEntry.arguments?.getInt("circuitId") ?: return@composable
            CircuitDetailScreen(
                circuitId = circuitId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = NavigationScreen.DriverDetail.route,
            arguments = listOf(
                navArgument("driverId") {
                    type = NavType.IntType
                }
            )
        ) {
            DriverDetailScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = NavigationScreen.NewsDetail.route,
            arguments = listOf(
                navArgument("newsUrl") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("newsUrl") ?: return@composable
            val decodedUrl = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8.toString())
            NewsWebViewScreen(
                newsUrl = decodedUrl,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
} 