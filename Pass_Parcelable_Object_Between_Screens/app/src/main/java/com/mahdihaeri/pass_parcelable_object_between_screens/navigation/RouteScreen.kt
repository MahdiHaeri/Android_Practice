package com.mahdihaeri.pass_parcelable_object_between_screens.navigation

sealed class RouteScreen(val route: String) {
    object HomeScreen: RouteScreen("home_screen")
    object DetailScreen: RouteScreen("detail_screen")
}
