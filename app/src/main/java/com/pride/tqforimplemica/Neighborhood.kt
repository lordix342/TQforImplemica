package com.pride.tqforimplemica



class Neighborhood (
    val roadFrom: String,
    val roadTo: String,
    val cost: Int
)
class ShortestPathResult(val prev: Map<String, String?>, val cost: Map<String, Int>, val source: String, val target: String) {

    fun shortestPath(from: String = source, to: String = target, list: List<String> = emptyList()): List<String> {
        val last = prev[to] ?: return if (from == to) {
            list + to
        } else {
            emptyList()
        }
        return shortestPath(from, last, list) + to
    }

    fun shortestCost(): Int? {
        val shortest = cost[target]
        if (shortest == Integer.MAX_VALUE) {
            return null
        }
        return shortest
    }
}