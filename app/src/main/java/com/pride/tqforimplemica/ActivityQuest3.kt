package com.pride.tqforimplemica

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pride.tqforimplemica.databinding.ActivityQuest3Binding
import java.math.BigInteger

class ActivityQuest3 : AppCompatActivity() {
    private lateinit var binding: ActivityQuest3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuest3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bcalc.setOnClickListener {
            calculateFactorial()
        }
    }
    private fun calculateFactorial() {
        val number = binding.editTextNumber.text
        var x = BigInteger("1")
        var y = BigInteger("0")
        if ((number == null)||(number.toString() == "")) {
            Toast.makeText(this, "Enter valid number", Toast.LENGTH_SHORT).show()
        } else {
            for (i in 1..number.toString().toLong()) {
                x *= i.toBigInteger()
                if (x.mod(10.toBigInteger())==0.toBigInteger()) x /= 10.toBigInteger()
            }
            val xString = x.toString()
            for (i in xString.indices) {
                y += (xString[i].digitToInt()).toBigInteger()
            }
            binding.textView.text = y.toString()
        }
    }
}