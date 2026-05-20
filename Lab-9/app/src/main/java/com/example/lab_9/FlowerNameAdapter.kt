package com.example.lab_9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.lab_9.databinding.FlowerListItem1Binding
import com.example.lab_9.databinding.FlowerListItemBinding

class FlowerNameAdapter(
    private val context: Context,
    private val flowerNames: ArrayList<String>,
    private val flowerImages: ArrayList<Int>
) : BaseAdapter() {

    override fun getCount(): Int {
        return flowerNames.size
    }

    override fun getItem(position: Int): Any {
        return flowerNames[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        val binding: FlowerListItem1Binding
        val itemView: View

        if (convertView == null) {

            binding = FlowerListItem1Binding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )

            itemView = binding.root
            itemView.tag = binding

        } else {

            itemView = convertView
            binding = itemView.tag as FlowerListItem1Binding
        }

        binding.flowerName.text = getItem(position).toString()
        binding.flowerImage.setImageResource(flowerImages[position])
        if (position % 2 == 0) {

            binding.flowerName.setBackgroundColor(
                android.graphics.Color.parseColor("#90EE90")
            )

        } else {

            binding.flowerName.setBackgroundColor(
                android.graphics.Color.WHITE
            )
        }


        return itemView
    }
}