package com.mahdihaeri.nestednavigation_practice.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mahdihaeri.nestednavigation_practice.navigation.ScreenRoute
import com.mahdihaeri.nestednavigation_practice.ui.LoginScreen
import com.mahdihaeri.nestednavigation_practice.ui.SignUpScreen

fun NavGraphBuilder.AuthNavGraph(
    navController: NavController
) {
    navigation(
        route = ScreenRoute.AuthGraph.route,
        startDestination = ScreenRoute.LoginScreen.route
    ) {
        composable(route = ScreenRoute.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = ScreenRoute.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
    }
}