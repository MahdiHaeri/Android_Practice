package com.mahdihaeri.sharedviewmodel_practice.navigation

sealed class RouteScreen(val route: String) {
    object HomeScreen: RouteScreen("home_screen")
    object DetailScreen: RouteScreen("detail_screen")
}
