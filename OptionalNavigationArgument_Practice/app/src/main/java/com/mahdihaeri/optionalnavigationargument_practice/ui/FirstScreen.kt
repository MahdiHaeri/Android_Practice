package com.mahdihaeri.optionalnavigationargument_practice.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mahdihaeri.optionalnavigationargument_practice.navigation.ScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    navController: NavController
) {
    val firstName = remember {
        mutableStateOf("")
    }

    val lastName = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = firstName.value,
            onValueChange = {
                firstName.value = it
            },
            label = {
                Text(text = "First Name (optional)")
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = lastName.value,
            onValueChange = {
                lastName.value = it
            },
            label = {
                Text(text = "Last Name (optional)")
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = {
                if (firstName.value.isNotEmpty() && lastName.value.isNotEmpty()) {
                    navController.navigate(
                        ScreenRoute.SecondScreen.route
                            .plus("?firstName=${firstName.value}&")
                            .plus("lastName=${lastName.value}")
                    )
                } else if (firstName.value.isNotEmpty()) {
                    navController.navigate(
                        ScreenRoute.SecondScreen.route
                            .plus("?firstName=${firstName.value}")
                    )
                } else if (lastName.value.isNotEmpty()) {
                    navController.navigate(
                        ScreenRoute.SecondScreen.route
                            .plus("?lastName=${lastName.value}")
                    )
                } else {
                    navController.navigate(
                        ScreenRoute.SecondScreen.route
                    )
                }
            }
        ) {
            Text(text = "Go to Second Screen")
        }
    }
}