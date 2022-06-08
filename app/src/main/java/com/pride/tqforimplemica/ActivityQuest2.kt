package com.pride.tqforimplemica

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pride.tqforimplemica.databinding.ActivityQuest2Binding

class ActivityQuest2 : AppCompatActivity(), OnItemSelectedListener {
    private lateinit var binding : ActivityQuest2Binding
    private val viewM : ViewModel by lazy { ViewModelProvider(this)[ViewModel::class.java] }
    var arr: ArrayList<String> = arrayListOf("gdansk","bydgoszcz","torun","warsawa")
    var nameStartCity : String = ""
    var nameEndCity : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuest2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinnerL = findViewById<Spinner>(R.id.spinner1)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, arr)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerL.adapter = adapter1
        spinnerL.setSelection(0)
        spinnerL.onItemSelectedListener = this

        val spinnerF = findViewById<Spinner>(R.id.spinner2)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, arr)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerF.adapter = adapter2
        spinnerF.setSelection(1)
        spinnerF.onItemSelectedListener = this
        binding.button2.setOnClickListener {
            viewM.startClick(nameStartCity, nameEndCity)
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0?.id) {
            R.id.spinner1 -> {
                nameStartCity = arr[p2]
            }
            R.id.spinner2 -> {
                nameEndCity = arr[p2]
            }
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}

