package twocolumns

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * Written by Milcho on 11/16/2018.
 */


fun main(args: Array<String>) {

    //val data = genColData(Random(4385L), 16)

    val rand = Random(4385L)
    val numTrials = 15
    (1..numTrials).forEach { _ ->
        val data = genColData(rand, 128 + rand.nextInt(32), 10)
        //val data = ColumnData(listOf(13, 2, 11, 3, 10, 9, 11, 13, 10, 10, 1), listOf(), listOf(), 46)
        println("Input = ${data.input}, expected max height = ${data.height}")
        var solution: Pair<MutableList<Int>, MutableList<Int>>? = null
        val timeMs = measureTimeMillis { solution = solveTwoColumns(data.input) }

        solution?.let {
            print("Solved = $it, Max Height = ${it.first.sum()}")
            if (it.first.sum() < data.height) {
                print(" !!! ERROR: LESSER OUTPUT !!! ")
            }
        } ?: print("No solution found!")
        println(" - Time taken = ${timeMs}ms\n")
    }
}

// entry point that sets up recursive function, for easier calling
fun solveTwoColumns(inputs: List<Int>): Pair<MutableList<Int>, MutableList<Int>>? {
    return solveTwoColumnsRec(LinkedList(), LinkedList(), 0, 0, LinkedList(inputs), inputs.sum() / 2)
}

fun solveTwoColumnsRec(
        col1: LinkedList<Int>,
        col2: LinkedList<Int>,
        sum1: Int,
        sum2: Int,
        inputs: LinkedList<Int>,
        maxPossibleHeight: Int): Pair<LinkedList<Int>, LinkedList<Int>>? {

    if (sum1 > maxPossibleHeight || sum2 > maxPossibleHeight) {
        return null // one of the two columns already exceeded the max height we can obtain, don't have to go further
    }
    if (sum1 == sum2 && inputs.size <= 1) {
        return Pair(LinkedList(col1), LinkedList(col2)) // equal heights with either 1 or 0 elements left = solved
    }
    if (sum1 != sum2 && inputs.size == 0) {
        return null // we ended up with different heights, but no input numbers left to add - can't solve it this way
    }

    var max = Pair(0, Pair(LinkedList<Int>(), LinkedList<Int>()))

    if (sum1 == sum2) {
        // symmetrical columns, we only have to try adding all possible options to one of them
        LinkedList(inputs).forEachIndexed() { index, it ->
            col1.add(it)
            inputs.remove(it)
            solveTwoColumnsRec(col1, col2, sum1 + it, sum2, inputs, maxPossibleHeight)?.let { solution ->
                if (solution.first.sum() > max.first) {
                    max = Pair(solution.first.sum(), Pair(solution.first, solution.second))
                    if (max.first == maxPossibleHeight) return max.second   // max height reached - don't have to continue
                }
            }
            col1.remove(it)
            inputs.add(it)
        }
    } else {
        LinkedList(inputs).forEach {
            col1.add(it)
            inputs.remove(it)
            solveTwoColumnsRec(col1, col2, sum1 + it, sum2, inputs, maxPossibleHeight)?.let { solution ->
                if (solution.first.sum() > max.first) {
                    max = Pair(solution.first.sum(), Pair(solution.first, solution.second))
                    if (max.first == maxPossibleHeight) return max.second   // max height reached - don't have to continue
                }
            }
            col1.remove(it)
            col2.add(it)
            solveTwoColumnsRec(col1, col2, sum1, sum2 + it, inputs, maxPossibleHeight)?.let { solution ->
                if (solution.first.sum() > max.first) {
                    max = Pair(solution.first.sum(), Pair(solution.first, solution.second))
                    if (max.first == maxPossibleHeight) return max.second   // max height reached - don't have to continue
                }
            }
            col2.remove(it)
            inputs.add(it)
        }
    }
    return if (max.first > 0) { max.second } else { null }
}