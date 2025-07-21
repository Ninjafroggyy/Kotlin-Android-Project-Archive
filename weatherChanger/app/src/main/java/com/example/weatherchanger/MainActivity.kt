package com.example.weatherchanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.weatherchanger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun changeWeather(view: View) {
        val image = binding.imageView

        if (image.tag == "storm") {
            image.setImageResource(R.drawable.sunny_image_2)
            image.tag = "sunny"
        } else {
            image.setImageResource(R.drawable.storm_image_1)
            image.tag = "storm"
        }
    }
}