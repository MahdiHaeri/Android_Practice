package com.swapwallet.retrofit_practice.util

sealed class NavDestination(val route: String) {
    object TodoListScreen : NavDestination("todo_list_screen")
}
