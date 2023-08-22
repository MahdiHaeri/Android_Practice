package com.mahdihaeri.screennavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.First.route
    ) {
        composable(route = Screen.First.route) {
            FirstScreen(navController = navController)
        }
        composable(route = Screen.Second.route) {
            SecondScreen(navController = navController)
        }
        composable(route = Screen.Third.route) {
            ThirdScreen(navController = navController)
        }
    }
}