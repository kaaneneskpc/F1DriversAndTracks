package com.example.f1drivers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.f1drivers.navigation.Screen.CircuitDetail
import com.example.f1drivers.navigation.Screen.Circuits
import com.example.f1drivers.navigation.Screen.DriverDetail
import com.example.f1drivers.navigation.Screen.Favorites
import com.example.f1drivers.navigation.Screen.Home
import com.example.f1drivers.navigation.Screen.RaceDetail
import com.example.f1drivers.navigation.Screen.Splash
import com.example.f1drivers.navigation.Screen.Standings
import com.example.f1drivers.presentation.circuits.CircuitsScreen
import com.example.f1drivers.presentation.circuits.detail.CircuitDetailScreen
import com.example.f1drivers.presentation.favorites.FavoritesScreen
import com.example.f1drivers.presentation.home.HomeScreen
import com.example.f1drivers.presentation.home.detail.DriverDetailScreen
import com.example.f1drivers.presentation.splash.SplashScreen
import com.example.f1drivers.presentation.standings.DriverStandingsScreen
import com.example.f1drivers.presentation.standings.RaceDetailScreen
import kotlinx.serialization.InternalSerializationApi


@OptIn(InternalSerializationApi::class)
@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashScreen(
                onNavigateToHome = {
                    navController.navigate(Home) {
                        popUpTo(Splash) { inclusive = true }
                    }
                }
            )
        }

        composable<Home> {
            HomeScreen(
                onDriverClick = { driverId ->
                    navController.navigate(DriverDetail(driverId))
                }
            )
        }

        composable<Favorites> {
            FavoritesScreen(
                onDriverClick = { driverId ->
                    navController.navigate(DriverDetail(driverId))
                }
            )
        }
        composable<Circuits> {
            CircuitsScreen(
                onCircuitClick = { circuitId ->
                    navController.navigate(CircuitDetail(circuitId))
                }
            )
        }
        composable<CircuitDetail> {
            val args = it.toRoute<CircuitDetail>()
            CircuitDetailScreen(
                circuitId = args.circuitId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable<DriverDetail> {
            DriverDetailScreen {
                navController.popBackStack()
            }
        }

        composable<Standings> {
            DriverStandingsScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onDriverClick = { driverId ->
                    navController.navigate(DriverDetail(driverId))
                },
                onTeamClick = { teamId ->
                    // TODO: Navigate to team detail screen when created
                },
                onRaceClick = { raceId ->
                    navController.navigate(RaceDetail(raceId))
                }
            )
        }

        composable<RaceDetail> {
            val args = it.toRoute<RaceDetail>()
            RaceDetailScreen(
                raceId = args.raceId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}