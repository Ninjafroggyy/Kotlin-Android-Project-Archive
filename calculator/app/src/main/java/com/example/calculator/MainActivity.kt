package com.example.calculator

import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    lateinit var txtInput: TextView
    var lastNumeric: Boolean = false
    var stateError: Boolean = false
    var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.txtInput)
        }

    fun onDigit(view: View) {
        if (stateError) {
            //If current state is Error, replace the error message
            txtInput.text = (view as Button).text
            stateError = false
        } else {
            //If not, already there is a valid expression so append to it
            txtInput.append((view as Button).text)
        }
        //Set the flag
        lastNumeric = true
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !stateError && !lastDot) {
            txtInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        if (lastNumeric && !stateError) {
            txtInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    fun onClear(view: View) {
        this.txtInput.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false
    }

    fun onEqual(view: View) {
        //if the current state is error, nothing to do
        //if the last input is a number only, solution can be found
        if (lastNumeric && !stateError) {
            //read the expression
            val txt = txtInput.text.toString()
            //create an expression (a class from exp4j library)
            val expression = ExpressionBuilder(txt).build()
            try {
                //calculate the result and display
                val result = expression.evaluate()
                txtInput.text = result.toString()
                lastDot = true //Result contains a dot
            } catch (ex: ArithmeticException) {
                //display an error message
                txtInput.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }

}