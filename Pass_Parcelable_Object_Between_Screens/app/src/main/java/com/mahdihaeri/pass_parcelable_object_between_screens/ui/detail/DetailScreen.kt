package com.mahdihaeri.pass_parcelable_object_between_screens.ui.detail

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
fun DetailScreen(
    navController: NavController,
    user: User = User("default first name", "default last name")
) {
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
    }
}