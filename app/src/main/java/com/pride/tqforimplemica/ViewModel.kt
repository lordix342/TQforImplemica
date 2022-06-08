package com.pride.tqforimplemica

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {
    var resultCost: MutableLiveData<Int> = MutableLiveData()
    val graph = listOf(
        Neighborhood("gdansk", "bydgoszcz", 1),
        Neighborhood("gdansk", "torun", 3),
        Neighborhood("bydgoszcz", "gdansk", 1),
        Neighborhood("bydgoszcz", "torun", 1),
        Neighborhood("bydgoszcz", "warsawa", 4),
        Neighborhood("torun", "gdansk", 3),
        Neighborhood("torun", "bydgoszcz", 1),
        Neighborhood("torun", "warsawa", 1),
        Neighborhood("warsawa", "bydgoszcz", 4),
        Neighborhood("warsawa", "torun", 1)
    )


    fun findShortestPath(edges: List<Neighborhood>, source: String, target: String): ShortestPathResult {

        // Note: this implementation uses similar variable names as the algorithm given do.
        // We found it more important to align with the algorithm than to use possibly more sensible naming.

        val cost = mutableMapOf<String, Int>()
        val prev = mutableMapOf<String, String?>()
        val q = findDistinctNeighborhood(edges)

        q.forEach { v ->
            cost[v] = Integer.MAX_VALUE
            prev[v] = null
        }
        cost[source] = 0

        while (q.isNotEmpty()) {
            val u = q.minByOrNull { cost[it] ?: 0 }
            q.remove(u)
            if (u == target) break // Found shortest path to target
            edges
                .filter { it.roadFrom == u }
                .forEach { edge ->
                    val v = edge.roadTo
                    val alt = (cost[u] ?: 0) + edge.cost
                    if (alt < (cost[v] ?: 0)) {
                        cost[v] = alt
                        prev[v] = u
                    }
                }
        }

        return ShortestPathResult(prev, cost, source, target)
    }
    private fun findDistinctNeighborhood(edges: List<Neighborhood>): MutableSet<String> {
        val roads = mutableSetOf<String>()
        edges.forEach {
            roads.add(it.roadFrom)
            roads.add(it.roadTo)
        }
        return roads
    }

    fun startClick(nameStartCity: String, finishCity: String) {
        val result = findShortestPath(graph, nameStartCity, finishCity)
        resultCost.value = result.shortestCost()
        Log.d("asg",resultCost.value.toString())

    }


}