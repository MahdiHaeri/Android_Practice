@file:OptIn(ExperimentalMaterial3Api::class)

package com.mahdihaeri.navigationargument_practice.ui

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
import com.mahdihaeri.requirenavigationargument_practice.navigation.ScreenRoute

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
                Text(text = "First Name")
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            value = lastName.value,
            onValueChange = {
                lastName.value = it
            },
            label = {
                Text(text = "Last Name")
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = {
                if (firstName.value.isNotEmpty() && lastName.value.isNotEmpty()) {
                    navController.navigate(
                        ScreenRoute.SecondScreen.route
                            .plus("/${firstName.value}")
                            .plus("/${lastName.value}")
                    )
                }
            }
        ) {
            Text(text = "Go to Second Screen")
        }
    }
}