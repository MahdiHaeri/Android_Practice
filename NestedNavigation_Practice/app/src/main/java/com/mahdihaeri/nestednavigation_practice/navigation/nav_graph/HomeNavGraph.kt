package com.mahdihaeri.nestednavigation_practice.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mahdihaeri.nestednavigation_practice.navigation.ScreenRoute
import com.mahdihaeri.nestednavigation_practice.ui.DetailScreen
import com.mahdihaeri.nestednavigation_practice.ui.HomeScreen

fun NavGraphBuilder.HomeNavGraph(
    navController: NavController
) {
    navigation(
        route = ScreenRoute.HomeGraph.route,
        startDestination = ScreenRoute.HomeScreen.route
    ) {
        composable(route = ScreenRoute.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = ScreenRoute.DetailScreen.route) {
            DetailScreen(navController = navController)
        }
    }
}