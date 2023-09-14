package com.mahdihaeri.requirenavigationargument_practice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mahdihaeri.navigationargument_practice.ui.FirstScreen
import com.mahdihaeri.navigationargument_practice.ui.SecondScreen

@Composable
fun SetupNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.FirstScreen.route,
    ) {
        composable(
            route = ScreenRoute.FirstScreen.route
        ) {
            FirstScreen(navController = navController)
        }

        composable(
            route = ScreenRoute.SecondScreen.route.plus("/{firstName}").plus("/{lastName}"),
            arguments = listOf(
                navArgument("firstName") {
                    defaultValue = "Default_First_Name"
                    type = NavType.StringType
                },
                navArgument("lastName") {
                    defaultValue = "Default_Last_Name"
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("firstName")
            val lastName = backStackEntry.arguments?.getString("lastName")
            if (firstName != null && lastName != null) {
                SecondScreen(navController = navController, firstName = firstName, lastName = lastName)
            }
        }
    }
}