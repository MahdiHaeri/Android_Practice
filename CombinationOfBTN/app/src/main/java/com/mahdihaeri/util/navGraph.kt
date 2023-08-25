package com.mahdihaeri.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mahdihaeri.screens.HomeScreen
import com.mahdihaeri.screens.ProfileScreen
import com.mahdihaeri.screens.SettingsScreen

@Composable
fun navGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.HOME.route
    ) {
        composable(route = ScreenRoute.HOME.route) {
            HomeScreen(navController = navController)
        }
        composable(route = ScreenRoute.PROFILE.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = ScreenRoute.SETTINGS.route) {
            SettingsScreen(navController = navController)
        }
    }
}
