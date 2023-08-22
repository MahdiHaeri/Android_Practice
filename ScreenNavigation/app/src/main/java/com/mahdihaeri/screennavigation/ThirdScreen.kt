package com.mahdihaeri.screennavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ThirdScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Third Screen",
            color = Color.Cyan,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                           navController.navigate(route = Screen.Second.route) {
                                 popUpTo(Screen.Second.route) {
                                      inclusive = true
                                 }
                           }
                },
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    ThirdScreen(navController = rememberNavController())
}