package com.mahdihaeri.util

sealed class ScreenRoute(val route: String) {
    object HOME : ScreenRoute("home_screen")
    object PROFILE : ScreenRoute("profile_screen")
    object SETTINGS : ScreenRoute("settings_screen")
}
