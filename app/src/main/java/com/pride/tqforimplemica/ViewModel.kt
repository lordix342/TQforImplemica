package com.pride.tqforimplemica

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {
    val gdansk: ArrayList<Neighborhood> =
        arrayListOf(Neighborhood("bydgoszcz", 1), Neighborhood("torun", 3))
    val bydgoszcz: ArrayList<Neighborhood> =
        arrayListOf(Neighborhood("gdansk", 1), Neighborhood("torun", 1), Neighborhood("warsawa", 4))
    val torun: ArrayList<Neighborhood> =
        arrayListOf(
            Neighborhood("gdansk", 3),
            Neighborhood("bydgoszcz", 1),
            Neighborhood("warsawa", 1)
        )
    val warsawa: ArrayList<Neighborhood> =
        arrayListOf(Neighborhood("torun", 1), Neighborhood("bydgoszcz", 4))

    fun startClick(nameStartCity: String, n: Int, finishCity: String) {

        when(nameStartCity) {
            "gdansk" -> {
                findNeighbor(gdansk, n, finishCity, nameStartCity)
            }
            "bydgoszcz" -> {
                findNeighbor(bydgoszcz,n,finishCity, nameStartCity)
            }
            "torun" -> {
                findNeighbor(torun,n,finishCity, nameStartCity)
            }
            "warsawa" -> {
                findNeighbor(warsawa,n,finishCity, nameStartCity)
            }
        }
        when(finishCity) {
            "gdansk" -> {
                findNeighbor(gdansk, n, finishCity, nameStartCity)
            }
            "bydgoszcz" -> {
                findNeighbor(bydgoszcz,n,finishCity, nameStartCity)
            }
            "torun" -> {
                findNeighbor(torun,n,finishCity, nameStartCity)
            }
            "warsawa" -> {
                findNeighbor(warsawa,n,finishCity, nameStartCity)
            }
        }

    }

    fun findNeighbor(startPos: ArrayList<Neighborhood>, n:Int, finishCity: String, startCity : String ) {
        var start = startPos
        var nextNeighbor : ArrayList<Neighborhood> = arrayListOf()
        var result: ArrayList<Result> = arrayListOf()
        var road = ""
        val cityfalse = arrayOf(startCity)
        var cost = 0
        var i = 0
        while (i<3) {
            for (city in start) {
                if (city.cityName!=finishCity) {
                    if (!cityfalse.contains(city.cityName))
                    {
                        when(city.cityName) {
                            "gdansk" -> {
                                for (city1 in gdansk) {
                                    if (city1.cityName!=finishCity) {
                                        cost += city.cost
                                        nextNeighbor = gdansk
                                        Log.d("gdansk", cost.toString())
                                        Log.d("gdanskroad", road)
                                    } else {
                                        cost += city.cost + city1.cost
                                        road=(road + city.cityName + city1.cityName)
                                        break
                                    }
                                }
                            }
                            "bydgoszcz" -> {
                                for (city1 in bydgoszcz) {
                                    if (city1.cityName!=finishCity) {
                                        cost +=city.cost
                                        nextNeighbor = bydgoszcz
                                        Log.d("bydgoszcz", cost.toString())
                                        Log.d("bydgoszcz", road)
                                    } else {
                                        cost +=city.cost + city1.cost
                                        road=(road + city.cityName + city1.cityName)
                                        break
                                    }
                                }
                            }
                            "torun" -> {
                                for (city1 in torun) {
                                    if (city1.cityName!=finishCity) {
                                        cost +=city.cost
                                        nextNeighbor = torun
                                        Log.d("torun", cost.toString())
                                        Log.d("torun", road)
                                    } else {
                                        cost +=city.cost + city1.cost
                                        road=(road + city.cityName + city1.cityName)
                                        break
                                    }
                                }
                            }
                            "warsawa" -> {
                                for (city1 in warsawa) {
                                    if (city1.cityName!=finishCity) {
                                        cost +=city.cost
                                        nextNeighbor = warsawa
                                        Log.d("warsawa", cost.toString())
                                        Log.d("warsawa", road)
                                    } else {
                                        cost +=city.cost + city1.cost
                                        road=(road + city.cityName + city1.cityName)
                                        break
                                    }
                                }
                            }
                        }
                    }

                } else {
                    road = city.cityName
                    cost +=city.cost
                    result.add(Result(road,cost))
                    break
                }
            }
            start = nextNeighbor
            i++
        }
        Log.d("result", cost.toString())
        Log.d("result1", road)
        Log.d("result2", result.toString())
    }
}