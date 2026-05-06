package com.example.lab_7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_7.databinding.ActivityMainBinding
import kotlin.toString

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var firstValue: Double = 0.0
    private var operator: String = ""
    private var isNewOp: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setNumberListeners()
    }
    private fun setNumberListeners() {
        val listener = View.OnClickListener { v ->
            val button = v as android.widget.Button
            if (isNewOp) { binding.calcDisplay.setText("")
            isNewOp = false }
            val newText = binding.calcDisplay.text.toString() + button.text
            binding.calcDisplay.setText(newText)
        }
val numButtons = listOf(
    binding.btn0,
        binding.btn1,
        binding.btn2,
        binding.btn3,
        binding.btn4,
        binding.btn5,
        binding.btn6,
        binding.btn7,
        binding.btn8,
        binding.btn9,
                binding.btnpunto )
        numButtons.forEach { it.setOnClickListener(listener) }

        val opListener = View.OnClickListener { v ->
            val button = v as android.widget.Button
            val currentText = binding.calcDisplay.text.toString()
            firstValue = currentText.toDoubleOrNull() ?: 0.0
            operator = button.text.toString()
            binding.calcDisplay.setText("$currentText $operator ")
            isNewOp = false

        }

        binding.btnslash.setOnClickListener(opListener)
        binding.btnresta.setOnClickListener(opListener)
        binding.btnpor.setOnClickListener(opListener)
        binding.btnsuma.setOnClickListener(opListener)

        binding.btnc.setOnClickListener {
            binding.calcDisplay.setText("0")
            firstValue = 0.0
            operator = ""
            isNewOp = true
        }

        binding.btnigual.setOnClickListener {
            calculateResult()
        }

    }

    private fun calculateResult() {
        val fullText = binding.calcDisplay.text.toString()
        val parts = fullText.split(" ")
        if (parts.size < 3) return
        val secondValue = parts.last().toDoubleOrNull() ?: 0.0
        var result = 0.0

        when (operator) {
            "/" -> {
                if (secondValue == 0.0) {
                    android.widget.Toast.makeText(this, "Error: División por 0", android.widget.Toast.LENGTH_SHORT).show()
                    result = 0.0
                } else {
                    result = firstValue / secondValue
                }
            }
            "*" -> result = firstValue * secondValue
            "-" -> result = firstValue - secondValue
            "+" -> result = firstValue + secondValue
        }
        binding.calcDisplay.setText(result.toString())
        isNewOp = true
    }
}



