package com.example.lab_9

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_9.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private val flowerNames = arrayListOf(
        "Rose",
        "Tulip",
        "Daisy"
    )
    private val flowerImages = arrayListOf(
        R.drawable.rose,
        R.drawable.tulip,
        R.drawable.daisy
    )
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


       // var adapter = ArrayAdapter(this,
         //   android.R.layout.simple_expandable_list_item_1,
       //     listOfFlowers)

      //  binding.flowerList.adapter = adapter

        val flowerAdapter = FlowerNameAdapter(this, flowerNames, flowerImages)
        binding.flowerList.adapter = flowerAdapter
    }


}