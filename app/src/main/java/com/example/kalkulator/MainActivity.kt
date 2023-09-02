package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.kalkulator.BinaryOperator
import com.example.kalkulator.databinding.ActivityMainBinding

typealias BinaryOperator = (Double, Double) -> Double

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var current: TextView
    private var changed = false
    private lateinit var operation: BinaryOperator

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        current = binding.number1

    }

    fun input(view: View) {
        with(binding){
            when ((view as AppCompatButton).text){


                "+" -> {
                    //Fungsi plus
                    current = number2
                    changed = false
                    operation = {a, b -> (a + b).toDouble()}
                }


                "-" -> {
                    current = number2
                    changed = false
                    operation = {a, b -> (a - b).toDouble()}
                }


                "/" -> {
                    current = number2
                    changed = false
                    operation = {a, b -> (a / b).toDouble()}
                }


                "X" -> {
                    current = number2
                    changed = false
                    operation  = {a, b -> (a * b).toDouble()}
                }

                "DEL" -> {
                    current = number1
                    number1.text = resources.getString(R.string.default1)
                    number2.text = resources.getString(R.string.default2)
                    result.text = resources.getString(R.string.default3)
                    changed = false
                }

                "=" -> {
                    val equals = operation((number1.text.toString()).toDouble(), (number2.text.toString()).toDouble())
                    result.text = equals.toString()
                }

                else -> {
                    if(!changed){
                        current.text = ""
                        changed = true
                    }
                    current.text = current.text.toString() + view.text.toString()
                }
            }
        }
    }
}