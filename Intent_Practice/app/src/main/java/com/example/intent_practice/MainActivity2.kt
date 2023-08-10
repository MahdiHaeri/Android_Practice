package com.example.intent_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent_practice.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main2)
        var data = intent.extras

        if (data != null) {
            binding.textViewMessage.text = data.getString("UserName")
        }
    }
}