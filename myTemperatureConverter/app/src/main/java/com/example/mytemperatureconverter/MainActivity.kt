package com.example.mytemperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mytemperatureconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun toCelsius(view: View) {
        val fahrenheitView = binding.inputTemp
        val fahrenheitValue = fahrenheitView.text.toString()
        if (!fahrenheitValue.isBlank()) {
            val myConvertedValue = (fahrenheitValue.toDouble() - 32) * 5/9
            val celsiusValue = String.format("%.2f", myConvertedValue)
            Toast.makeText(this, "$fahrenheitValue fahrenheit is $celsiusValue degrees celsius",
                                            Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this, "You must enter a value to convert", Toast.LENGTH_LONG).show()
        }
        Log.i("fahrenheit value", fahrenheitValue)

    }

    fun toFahrenheit(view: View) {
        val celsiusView = binding.inputTemp
        val celsiusValue = celsiusView.text.toString()
        if (!celsiusValue.isBlank()) {
            val myConvertedValue = celsiusValue.toDouble() * 9/5 + 32
            val fahrenheitValue = String.format("%.2f", myConvertedValue)
            Toast.makeText(this, "$celsiusValue fahrenheit is $fahrenheitValue degrees celsius",
                Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this, "You must enter a value to convert", Toast.LENGTH_LONG).show()
        }
        Log.i("fahrenheit value", celsiusValue)
    }
}