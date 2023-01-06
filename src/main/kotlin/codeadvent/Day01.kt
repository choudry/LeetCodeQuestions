package codeadvent

import java.io.File


/**
 * Day 1
 * Find the two entries that sum to target and then multiply those two numbers together and return the result.
 */


fun List<Int>.findPairOfSum(target: Int): Pair<Int, Int>? {
    val complements = associateBy { target - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }
}

// Part Two
fun List<Int>.findTripleOfSum(target: Int): Triple<Int, Int, Int>? {
    return firstNotNullOfOrNull { x ->
        findPairOfSum(target - x)?.let { pair ->
            Triple(x, pair.first, pair.second)
        }
    }
}

fun main() {
    val numbers = File("src/day01/day01input.txt")
        .readLines()
        .map(String::toInt)

    val twoProduct = numbers.findPairOfSum(2020)
    println("Result: ${twoProduct?.let { it.second * it.second }}")

    val tripleOfSum = numbers.findTripleOfSum(2020)
    println("Result: ${tripleOfSum?.let { it.first * it.second * it.third }}")
}