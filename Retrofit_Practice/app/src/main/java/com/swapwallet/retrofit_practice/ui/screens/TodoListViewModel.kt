package com.swapwallet.retrofit_practice.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.swapwallet.retrofit_practice.model.Todo
import com.swapwallet.retrofit_practice.network.RetrofitInstance
import kotlinx.coroutines.runBlocking

class TodoListViewModel : ViewModel() {
    var todoListItem by mutableStateOf<List<Todo>>(emptyList())
        private set

    init {
        runBlocking {
            getTodos()
        }
    }

    private suspend fun getTodos() {
        val response = try {
            RetrofitInstance.api.getTodos()
        } catch (e: Exception) {
            null
        }

        if (response != null && response.isSuccessful && response.body() != null) {
            todoListItem = response.body()!!
        } else {
            println("Response not successfully ")
        }
    }
}