package com.mahdihaeri.requirenavigationargument_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mahdihaeri.requirenavigationargument_practice.navigation.SetupNavHost
import com.mahdihaeri.requirenavigationargument_practice.ui.theme.RequireNavigationArgument_PracticeTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RequireNavigationArgument_PracticeTheme {
                navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}
