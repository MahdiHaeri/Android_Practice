package com.swapwallet.retrofit_practice.util

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.swapwallet.retrofit_practice.ui.screens.TodoListScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavDestination.TodoListScreen.route,
        modifier = modifier
    ) {
        composable(route = NavDestination.TodoListScreen.route) {
            TodoListScreen(navController = navController, modifier = modifier)
        }
    }
}