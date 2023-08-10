package com.example.activity_project

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activity_project.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        val selectedItem = intent.getStringExtra("selectedItem")
        binding.textViewSelectedItem.text = selectedItem

        val rootSet = AnimatorSet()
        val fadeAnimator = ObjectAnimator.ofFloat(binding.txtSearching, "alpha", 0f, 1f)
        fadeAnimator.apply {
            duration = 1000
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }

        rootSet.playTogether(fadeAnimator)
        rootSet.start()
    }
}