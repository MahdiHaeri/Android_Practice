package com.mahdihaeri.pass_parcelable_object_between_screens.ui.home

import android.app.Person
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mahdihaeri.pass_parcelable_object_between_screens.model.User
import com.mahdihaeri.pass_parcelable_object_between_screens.navigation.RouteScreen

@Composable
fun HomeScreen(
    navController: NavController
) {
    var user = User(firstName = "Mahdi", lastName = "Haeri")
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home",
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            color = Color.Red
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "user",
                    value = user
                )
                navController.navigate(RouteScreen.DetailScreen.route)
            }
        ) {
            Text(text = "Go to Detail Screen")
        }
    }
}