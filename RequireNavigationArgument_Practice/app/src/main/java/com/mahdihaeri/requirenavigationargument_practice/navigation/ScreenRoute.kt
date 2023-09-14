package com.mahdihaeri.requirenavigationargument_practice.navigation

sealed class ScreenRoute(val route: String) {
    object FirstScreen: ScreenRoute("first_screen")
    object SecondScreen: ScreenRoute("second_screen")
}
