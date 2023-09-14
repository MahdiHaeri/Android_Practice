package com.mahdihaeri.nestednavigation_practice.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mahdihaeri.nestednavigation_practice.navigation.ScreenRoute

@Composable
fun SetupNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.HomeGraph.route,
    ) {
        HomeNavGraph(navController = navController)
        AuthNavGraph(navController = navController)
    }
}