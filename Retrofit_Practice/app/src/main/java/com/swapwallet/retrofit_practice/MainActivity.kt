package com.swapwallet.retrofit_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
;
import com.swapwallet.retrofit_practice.ui.theme.Retrofit_PracticeTheme
import com.swapwallet.retrofit_practice.util.MainNavHost

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Retrofit_PracticeTheme {
                // A surface container using the 'background' color from the theme

                navController = rememberNavController()
                MainNavHost(navController = navController, modifier = Modifier.padding(8.dp))
            }
        }
    }
}