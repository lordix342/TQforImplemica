package com.pride.tqforimplemica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pride.tqforimplemica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bexit.setOnClickListener {
            finish()
        }
        binding.bquest1.setOnClickListener {
            val intent = Intent(this, ActivityQuest1::class.java)
            startActivity(intent)
        }
        binding.bquest2.setOnClickListener {
            val intent = Intent(this, ActivityQuest2::class.java)
            startActivity(intent)
        }
        binding.bquest3.setOnClickListener {
            val intent = Intent(this, ActivityQuest3::class.java)
            startActivity(intent)
        }
    }
}