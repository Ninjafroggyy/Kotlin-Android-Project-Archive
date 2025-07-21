package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.loginscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun clickFunction(view: View) {
        Log.i("Entered Email", binding.editEmailField.text.toString())
        Log.i("Entered Password", binding.editPasswordField.text.toString())
        Log.i("Info", "Logged in")
        val emailText = binding.editEmailField.text
        Toast.makeText(this, "Hello $emailText", Toast.LENGTH_SHORT).show()
    }
}
