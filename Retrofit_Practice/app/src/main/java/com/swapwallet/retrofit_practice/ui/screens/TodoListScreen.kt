package com.swapwallet.retrofit_practice.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.swapwallet.retrofit_practice.ui.component.TodoItem

@Composable
fun TodoListScreen(navController : NavController, modifier: Modifier = Modifier) {
    val viewModel = TodoListViewModel()
    var todos = viewModel.todoListItem
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(todos.size) { index ->
                    TodoItem(
                        title = todos[index].title,
                        completed = todos[index].completed
                    )
                }
            }
        )
    }
}
