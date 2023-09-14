package com.mahdihaeri.nestednavigation_practice.navigation

sealed class ScreenRoute(val route: String) {
    object LoginScreen: ScreenRoute("login_screen")
    object SignUpScreen: ScreenRoute("sign_up_screen")
    object HomeScreen: ScreenRoute("home_screen")
    object DetailScreen: ScreenRoute("detail_screen")

    object HomeGraph: ScreenRoute("home_graph")
    object AuthGraph: ScreenRoute("auth_graph")
}
