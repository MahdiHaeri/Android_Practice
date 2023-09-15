package com.mahdihaeri.sharedviewmodel_practice.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mahdihaeri.sharedviewmodel_practice.model.User
import com.mahdihaeri.sharedviewmodel_practice.navigation.RouteScreen
import com.mahdihaeri.sharedviewmodel_practice.ui.view_model.SharedViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
) {
    val user = sharedViewModel.user!!
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Detail",
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            color = Color.Green
        )

        Text(text = user.firstName)
        Text(text = user.lastName)

        Button(onClick = {
            navController.navigate(RouteScreen.HomeScreen.route) {
                popUpTo(RouteScreen.HomeScreen.route) {
                    inclusive = true
                }
            }
        }) {
            Text(text = "Go to Home Screen")
        }

        Spacer(modifier = Modifier.size(8.dp))
    }
}