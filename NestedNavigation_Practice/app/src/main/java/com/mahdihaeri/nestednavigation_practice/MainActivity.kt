package com.mahdihaeri.nestednavigation_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mahdihaeri.nestednavigation_practice.ui.theme.NestedNavigation_PracticeTheme
import com.mahdihaeri.nestednavigation_practice.navigation.nav_graph.SetupNavHost

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedNavigation_PracticeTheme {
                navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}
