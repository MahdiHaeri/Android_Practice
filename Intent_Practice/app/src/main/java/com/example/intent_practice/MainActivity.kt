package com.example.intent_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intent_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
    }

    fun onChangeActivityButtonClicked(view: View) {
        val userName = binding.editTextText.text.toString()
        val secondActivityIntent = Intent(this, MainActivity2::class.java)
        secondActivityIntent.putExtra("UserName", userName)
        startActivity(secondActivityIntent)
    }
}