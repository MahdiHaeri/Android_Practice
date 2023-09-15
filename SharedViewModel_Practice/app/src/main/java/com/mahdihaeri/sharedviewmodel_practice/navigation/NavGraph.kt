package com.mahdihaeri.sharedviewmodel_practice.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mahdihaeri.sharedviewmodel_practice.model.User
import com.mahdihaeri.sharedviewmodel_practice.ui.detail.DetailScreen
import com.mahdihaeri.sharedviewmodel_practice.ui.home.HomeScreen
import com.mahdihaeri.sharedviewmodel_practice.ui.view_model.SharedViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    val sharedViewModel: SharedViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = RouteScreen.HomeScreen.route
    ) {
        composable(RouteScreen.HomeScreen.route) {
            HomeScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

        composable(RouteScreen.DetailScreen.route) {
            DetailScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
    }
}
