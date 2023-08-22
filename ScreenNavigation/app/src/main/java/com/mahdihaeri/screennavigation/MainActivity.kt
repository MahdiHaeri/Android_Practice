package com.mahdihaeri.screennavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mahdihaeri.screennavigation.ui.theme.ScreenNavigationTheme

class MainActivity : ComponentActivity() {
    lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenNavigationTheme {
                // A surface container using the 'background' color from the theme

                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}