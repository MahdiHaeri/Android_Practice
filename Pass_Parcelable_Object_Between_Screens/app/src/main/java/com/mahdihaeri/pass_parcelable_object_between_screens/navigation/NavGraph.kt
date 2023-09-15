package com.mahdihaeri.pass_parcelable_object_between_screens.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mahdihaeri.pass_parcelable_object_between_screens.model.User
import com.mahdihaeri.pass_parcelable_object_between_screens.ui.detail.DetailScreen
import com.mahdihaeri.pass_parcelable_object_between_screens.ui.home.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RouteScreen.HomeScreen.route
    ) {
        composable(RouteScreen.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(RouteScreen.DetailScreen.route) {
            var result = navController.previousBackStackEntry?.savedStateHandle?.get<User>("user")
            LaunchedEffect(key1 = it) {
                Log.d("TAG", "SetupNavGraph: ${result?.firstName}")
                Log.d("TAG", "SetupNavGraph: ${result?.lastName}")
            }
            DetailScreen(navController, user = result!!)
        }
    }
}
