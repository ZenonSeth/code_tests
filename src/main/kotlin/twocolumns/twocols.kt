package twocolumns

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * Written by Milcho on 11/16/2018.
 */


fun main(args: Array<String>) {

    //val data = genColData(Random(4385L), 16)

    val rand = Random(4385L)
    val numTrials = 1
    (1..numTrials).forEach { _ ->
        //val data = genColData(rand, 1024 + rand.nextInt(32), 20)
        val data = ColumnData(listOf(4,4,3,3,3,1), listOf(), listOf(), 46)
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
    return solveTwoColumnsRec(LinkedList(), LinkedList(), 0, 0, 0, 0, ArrayList(inputs), inputs.size, inputs.sum() / 2)
}

fun solveTwoColumnsRec(
        col1: LinkedList<Int>, col2: LinkedList<Int>,
        sum1: Int, sum2: Int,
        index1: Int, index2: Int,
        inputs: MutableList<Int>,
        numInputsLeft: Int,
        maxPossibleHeight: Int
): Pair<LinkedList<Int>, LinkedList<Int>>? {

    if (sum1 > maxPossibleHeight || sum2 > maxPossibleHeight) {
        return null // one of the two columns already exceeded the max height we can obtain, don't have to go further
    }
    if (sum1 == sum2 && numInputsLeft <= 1) {
        return Pair(LinkedList(col1), LinkedList(col2)) // equal heights with either 1 or 0 elements left = solved
    }
    if (sum1 != sum2 && numInputsLeft == 0) {
        return null // we ended up with different heights, but no input numbers left to add - can't solve it this way
    }

    val asymmetricalLists = sum1 != sum2
    var max = Pair(0, Pair(LinkedList<Int>(), LinkedList<Int>()))
    for (index in 0 until inputs.size) {
        val it = inputs[index]
        //if (index1 == 0 && index2 == 0) println("l0: $index / ${inputs.size}")
        //if (index1 == 1 || index2 == 1) println("l1: $index / ${inputs.size}")
        inputs[index] = -1
        if (it != -1 && index >= index1) {
            col1.add(it)
            solveTwoColumnsRec(col1, col2, sum1 + it, sum2, index+1, index2, inputs, numInputsLeft-1, maxPossibleHeight)?.let { solution ->
                if (solution.first.sum() > max.first) {
                    max = Pair(solution.first.sum(), Pair(solution.first, solution.second))
                    if (max.first == maxPossibleHeight) return max.second   // max height reached - don't have to continue
                }
            }
            col1.remove(it)
        }
        if (it != -1 && asymmetricalLists && index >= index2) {
            col2.add(it)
            solveTwoColumnsRec(col1, col2, sum1, sum2 + it, index1, index+1, inputs, numInputsLeft-1, maxPossibleHeight)?.let { solution ->
                if (solution.first.sum() > max.first) {
                    max = Pair(solution.first.sum(), Pair(solution.first, solution.second))
                    if (max.first == maxPossibleHeight) return max.second   // max height reached - don't have to continue
                }
            }
            col2.remove(it)
        }
        inputs[index] = it
    }
    return when {
        max.first > 0 -> max.second
        sum1 == sum2 -> Pair(LinkedList(col1), LinkedList(col2))
        else -> null
    }
}
