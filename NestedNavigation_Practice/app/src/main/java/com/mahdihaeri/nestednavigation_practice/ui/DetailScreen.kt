package com.mahdihaeri.nestednavigation_practice.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mahdihaeri.nestednavigation_practice.navigation.ScreenRoute

@Composable
fun DetailScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Detail")

        Button(
            onClick = {
                navController.navigate(ScreenRoute.HomeScreen.route) {
                    popUpTo(ScreenRoute.HomeScreen.route) {
                        inclusive = true
                    }
                }
            }
        ) {
            Text(text = "Back to home")
        }
    }
}