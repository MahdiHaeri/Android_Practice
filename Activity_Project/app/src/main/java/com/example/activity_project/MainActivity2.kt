package com.example.activity_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.activity_project.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var selectedItem: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
    }

    fun onToggleButton_Andriod(view: View) {
        binding.toggleButtonWeb.isChecked = false
        binding.toggleButtonBackend.isChecked = false
        changeSelectedItem("Android Developer")
    }

    fun onToggleButton_web(view: View) {
        binding.toggleButtonAndriod.isChecked = false
        binding.toggleButtonBackend.isChecked = false
        changeSelectedItem("Web Developer")
    }

    fun onToggleButton_backend(view: View) {
        binding.toggleButtonAndriod.isChecked = false
        binding.toggleButtonWeb.isChecked = false
        changeSelectedItem("Backend Developer")
    }

    fun changeSelectedItem(selectedItem: String) {
        if (this.selectedItem == selectedItem) {
            this.selectedItem = ""
        } else {
            this.selectedItem = selectedItem
        }
    }

    fun onSearchButtonClicked(view: View) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("selectedItem", selectedItem)
        startActivity(intent)
    }
}