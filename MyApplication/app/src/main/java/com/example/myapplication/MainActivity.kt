package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
        binding.CheckBoxFootball.setOnClickListener(this)
        binding.CheckBoxVallyball.setOnClickListener(this)
        binding.CheckBoxTenis.setOnClickListener(this)

    }

    fun onCheckboxClicked(view: View) {
    }

    override fun onClick(view: View?) {
        view as CheckBox

        val checked: Boolean = view.isChecked

        when (view.id) {
            R.id.CheckBoxFootball -> if (checked) {
                binding.CheckBoxTenis.isChecked = true
                Toast.makeText(this, "football", Toast.LENGTH_SHORT).show()
            } else {
                binding.CheckBoxTenis.isChecked = false
                Toast.makeText(this, "football", Toast.LENGTH_SHORT).show()
            }

            R.id.CheckBoxVallyball -> if (checked) {
                Toast.makeText(this, "vallyball", Toast.LENGTH_SHORT).show()
            }

            R.id.CheckBoxTenis -> if (checked) {
                binding.CheckBoxFootball.isChecked = true
                Toast.makeText(this, "tenis", Toast.LENGTH_SHORT).show()
            } else {
                binding.CheckBoxFootball.isChecked = false
                Toast.makeText(this, "tenis", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
