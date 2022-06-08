package com.pride.tqforimplemica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pride.tqforimplemica.databinding.ActivityQuest1Binding

class ActivityQuest1 : AppCompatActivity() {
    private lateinit var binding: ActivityQuest1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuest1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            quest1()
        }
    }
    private fun quest1() {
        val n = binding.editTextNumber.text.toString()
        var result = ""
        if (n=="") {
            Toast.makeText(this, "Enter valid number", Toast.LENGTH_SHORT).show()
        } else {
            when(n.toInt()) {
                1 -> { result = "1" }
                2 -> { result = "2" }
                else -> {
                    val nFact = n.toInt() * 2 - 2
                    var sumnFact = 1
                    var delsumFact = 1
                    for (i in 1..nFact) {
                        sumnFact *=i
                    }
                    for (i in 1..nFact-2) {
                        delsumFact *=i
                    }
                    result = (((sumnFact / 2)/delsumFact)-1).toString()
                }
            }
        }
        binding.textView2.text = result
    }
}