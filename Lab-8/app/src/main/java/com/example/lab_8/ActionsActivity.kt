package com.example.lab_8

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_8.databinding.ActivityActionsBinding

class ActionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnWriteLogcat.setOnClickListener {
            Log.d("LAB_ANDROID", "Hello, I'm writing to the console from ActionsActivity")
        }

        binding.btnShowToast.setOnClickListener {
            Toast.makeText(this, "¡Message showed!", Toast.LENGTH_SHORT).show()
        }

        binding.btnWriteEdittext.setOnClickListener {

            Toast.makeText(this, "Writing", Toast.LENGTH_SHORT).show()
        }

        binding.btnBackToFirstFragment.setOnClickListener {
            finish()
        }
    }
}