package com.mahdihaeri.sharedviewmodel_practice.ui.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mahdihaeri.sharedviewmodel_practice.model.User

class SharedViewModel(): ViewModel() {
    var user by mutableStateOf<User?>(null)
        private set

    fun updateUser(newUser: User) {
        user = newUser
    }
}