package com.mahdihaeri.optionalnavigationargument_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mahdihaeri.optionalnavigationargument_practice.navigation.SetupNavHost
import com.mahdihaeri.optionalnavigationargument_practice.ui.theme.OptionalNavigationArgument_PracticeTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OptionalNavigationArgument_PracticeTheme {
                navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}
