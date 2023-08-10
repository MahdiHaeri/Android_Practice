package com.example.calculator_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator_application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedOperation: String = ""
    private var oldNumber: String = ""
    private var isNewOperation: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
    }

    fun clickButtonEvent(view: View) {
        if (isNewOperation) {
            clearShowNumber()
        }
        isNewOperation = false
        val selectedButton = view as Button
        val currentNumber = binding.showNumber.text.toString()
        val newNumber = setNextCharacter(currentNumber, selectedButton)
        binding.showNumber.text = newNumber
    }

    private fun setNextCharacter(currentNumber: String, selectedButton: Button): String {
        var newNumber = currentNumber
        when (selectedButton.id) {
            binding.btn0.id -> {
                if (newNumber != "0") {
                    newNumber += "0"
                }
            }

            binding.btn1.id -> {
                if (newNumber == "0") {
                    newNumber = "1"
                } else {
                    newNumber += "1"
                }
            }

            binding.btn2.id -> {
                if (newNumber == "0") {
                    newNumber = "2"
                } else {
                    newNumber += "2"
                }
            }

            binding.btn3.id -> {
                if (newNumber == "0") {
                    newNumber = "3"
                } else {
                    newNumber += "3"
                }
            }

            binding.btn4.id -> {
                if (newNumber == "0") {
                    newNumber = "4"
                } else {
                    newNumber += "4"
                }
            }

            binding.btn5.id -> {
                if (newNumber == "0") {
                    newNumber = "5"
                } else {
                    newNumber += "5"
                }
            }

            binding.btn6.id -> {
                if (newNumber == "0") {
                    newNumber = "6"
                } else {
                    newNumber += "6"
                }
            }

            binding.btn7.id -> {
                if (newNumber == "0") {
                    newNumber = "7"
                } else {
                    newNumber += "7"
                }
            }

            binding.btn8.id -> {
                if (newNumber == "0") {
                    newNumber = "8"
                } else {
                    newNumber += "8"
                }
            }

            binding.btn9.id -> {
                if (newNumber == "0") {
                    newNumber = "9"
                } else {
                    newNumber += "9"
                }
            }

            binding.btnDot.id -> {
                if (!newNumber.contains(".")) {
                    newNumber += "."
                }
            }
        }
        return newNumber
    }

    fun plusMinesEvent(view: View) {
        val number = binding.showNumber.text.toString().toDouble() * -1
        binding.showNumber.text = number.toString()
        isNewOperation = true
    }

    fun operationEvent(view: View) {
        val selectedButton = view as Button
        when (selectedButton.id) {
            binding.btnPlus.id -> {
                selectedOperation = "+"
            }

            binding.btnMinus.id -> {
                selectedOperation = "-"
            }

            binding.btnMultiply.id -> {
                selectedOperation = "*"
            }

            binding.btnDivide.id -> {
                selectedOperation = "/"
            }
        }
        isNewOperation = true
        oldNumber = binding.showNumber.text.toString()
    }

    private fun clearShowNumber() {
        binding.showNumber.text = "0"
    }

    fun equalEvent(view: View) {
        val newNumber = binding.showNumber.text.toString()
        var result: Double? = null
        if (selectedOperation != "" && oldNumber != "") {
            when (selectedOperation) {
                "+" -> {
                    result = oldNumber.toDouble() + newNumber.toDouble()
                }

                "-" -> {
                    result = oldNumber.toDouble() - newNumber.toDouble()
                }

                "*" -> {
                    result = oldNumber.toDouble() * newNumber.toDouble()
                }

                "/" -> {
                    result = oldNumber.toDouble() / newNumber.toDouble()
                }
            }
            binding.showNumber.text = result.toString()
            isNewOperation = true
            selectedOperation = ""
            oldNumber = ""
        }
    }

    fun percentEvent(view: View) {
        val number = binding.showNumber.text.toString().toDouble() / 100
        binding.showNumber.text = number.toString()
        isNewOperation = true
    }

    fun clearEvent(view: View) {
        clearShowNumber()
        isNewOperation = true
        selectedOperation = ""
    }
}