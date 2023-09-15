@file:OptIn(ExperimentalMaterial3Api::class)

package com.mahdihaeri.sharedviewmodel_practice.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mahdihaeri.sharedviewmodel_practice.model.User
import com.mahdihaeri.sharedviewmodel_practice.navigation.RouteScreen
import com.mahdihaeri.sharedviewmodel_practice.ui.view_model.SharedViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val firstName = remember {
        mutableStateOf("")
    }

    val lastName = remember {
        mutableStateOf("")
    }

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
        TextField(
            value = firstName.value,
            onValueChange = {
                firstName.value = it
            },
            label = {
                Text(text = "First Name")
            }
        )

        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = lastName.value,
            onValueChange = {
                lastName.value = it
            },
            label = {
                Text(text = "Last Name")
            }
        )

        Button(
            onClick = {
                sharedViewModel.updateUser(
                    User(
                        firstName = firstName.value,
                        lastName = lastName.value
                    )
                )
                navController.navigate(RouteScreen.DetailScreen.route)
            }
        ) {
            Text(text = "Go to Detail Screen")
        }
    }
}