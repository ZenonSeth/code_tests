import java.util.*
import kotlin.math.abs
import kotlin.system.measureTimeMillis

/**
 * Written by Milcho on 10/20/2018.
 */


fun main(args: Array<String>) {
    val rand = Random()


    val numTrials = 100
    val listSize = 50
    val range = 10000

    var verifyTotalTime = 0L
    var testTotalTime = 0L
    var isValid = true

    for (nt in 1..numTrials) {
        val input = randomList(rand, listSize, range)
        val targetSum = rand.nextInt() % range
        //val targetSum = 5

        var valid = listOf<Triple<Int, Int, Int>>()
        var test = listOf<Triple<Int, Int, Int>>()

        val timeValid = measureTimeMillis { valid = verify(input, targetSum) }
        val timeTest = measureTimeMillis { test = solution(input, targetSum) }
        //print("Valid: $valid")
        //println("Test: $test")

        val matches = test.size == valid.size
        verifyTotalTime += timeValid
        testTotalTime += timeTest
        isValid = isValid && matches
    }
    println("Valid = $isValid" +
            "\nAverage Verf Time = ${verifyTotalTime.toFloat() / numTrials.toFloat()}" +
            "\nAverage Your Time = ${testTotalTime.toFloat() / numTrials.toFloat()}")
}

fun randomList(rand: Random, listSize: Int, range: Int): Array<Int> {
    return Array(listSize) { abs(rand.nextInt() % range) }
    //return arrayOf(0,1,2,3,4,5,6)
}


fun solution(input: Array<Int>, sum: Int): List<Triple<Int, Int, Int>> {
    // Change this to call your solution
    return threeSum(input, sum)
}


fun threeSum(input: Array<Int>, sum: Int): List<Triple<Int, Int, Int>> {
    val list = input.toList()
    //mlist.removeAt(index)
    val output = mutableListOf<Triple<Int, Int, Int>>()

    list.forEachIndexed { index: Int, value: Int ->
        //println(">>> Analytzing Index $index, val = $value" )
        if (value <= sum) {
            val twos = twoSum(list.subList(index+1, list.size), sum - value)
            twos.forEach {
                output.add(Triple(value, it.first, it.second))
            }
        }
    }
    return output
}

fun twoSum(input: List<Int>, sum: Int): List<Pair<Int, Int>> {
    val expected = mutableSetOf<Int>()
    val output = mutableListOf<Pair<Int, Int>>()
    //print("finding pairs for sum of $sum")
    input.forEach {
        if (expected.contains(it)) {
            output.add(Pair(it, sum - it))
        }
        expected.add(sum - it)
    }
    //println(" = $output")
    return output
}


fun verify(input: Array<Int>, sum: Int): List<Triple<Int, Int, Int>> {
    val output = mutableListOf<Triple<Int, Int, Int>>()

    for (i in 0 until input.size) {
        for (j in i + 1 until input.size) {
            for (k in j + 1 until input.size) {
                if (input[i] + input[j] + input[k] == sum) {
                    output.add(Triple(input[i], input[j], input[k]))
                }
            }
        }
    }

    return output
}