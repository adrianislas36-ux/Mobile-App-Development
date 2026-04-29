package com.example.juanislaslayoutsandactions

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.juanislaslayoutsandactions.databinding.LayoutActionsBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: LayoutActionsBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = LayoutActionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = ViewModelProvider(this)[User::class.java]
        user.firstName.value = "Adrian"
        user.lastName.value = "The graeat"


        binding.user = user
        binding.lifecycleOwner = this



        ViewCompat.setOnApplyWindowInsetsListener(binding.actions) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setWriteToLogCatButtonListener()
        setShowToastButtonListener()
        setWriteToTextViewButtonListener()
        setUpdateUserDataButtonListener()
    }

    private fun setWriteToLogCatButtonListener() {
        binding.btnWriteToLogcat.setOnClickListener {
            Log.i("MyAppList", "Message from the Bindlistener")
        }
    }

    private fun setShowToastButtonListener() {
        binding.btnShowToast.setOnClickListener {
            android.widget.Toast.makeText(this, "Message From My App", android.widget.Toast.LENGTH_LONG).show()
        }
    }

    private fun setWriteToTextViewButtonListener() {
        binding.btnWriteToTextview.setOnClickListener {
            binding.tvWriteSomething.text = "I love this game"
        }
    }

    private fun setUpdateUserDataButtonListener() {
        binding.btnUpdateUserData.setOnClickListener {
            user.firstName.value = "Tamara"
            user.lastName.value = "Smith"

        }
    }
    fun writeToLogCat(view: View) {
        Log.i("MyApp", "Message from my App")
    }
}