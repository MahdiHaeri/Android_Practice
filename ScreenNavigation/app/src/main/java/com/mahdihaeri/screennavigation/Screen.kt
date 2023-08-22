package com.mahdihaeri.screennavigation

sealed class Screen(val route: String) {
    object First : Screen("first_screen")
    object Second : Screen("second_screen")
    object Third : Screen("third_screen")
}
