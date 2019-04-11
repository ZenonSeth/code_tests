package random

import java.util.*


fun main(args: Array<String>) {
    //println(genColData(Random(), 256))
    val soln = solveTwoColumns(listOf(21, 38, 46, 41, 12, 21, 27, 55, 31, 18, 39, 23, 30, 17, 24, 5, 35, 22, 7))
    println(soln?.first?.sum())
    println(soln)
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
        inputs[index] = -1
        if (it != -1 && index >= index1) {
            col1.add(it)
            solveTwoColumnsRec(col1, col2, sum1 + it, sum2, index + 1, index2, inputs, numInputsLeft - 1, maxPossibleHeight)?.let { solution ->
                if (solution.first.sum() > max.first) {
                    max = Pair(solution.first.sum(), Pair(solution.first, solution.second))
                    if (max.first == maxPossibleHeight) return max.second   // max height reached - don't have to continue
                }
            }
            col1.remove(it)
        }
        if (it != -1 && asymmetricalLists && index >= index2) {
            col2.add(it)
            solveTwoColumnsRec(col1, col2, sum1, sum2 + it, index1, index + 1, inputs, numInputsLeft - 1, maxPossibleHeight)?.let { solution ->
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

data class ColumnData(val input: List<Int>, val rCol: List<Int>, val lCol: List<Int>, val height: Int)

fun genColData(rand: Random = Random(), targetHeight: Int = -1): ColumnData {
    val height = if (targetHeight > 0) {targetHeight} else {8 + rand.nextInt(64)}
    val col1 = breakCol(height, rand)
    val col2 = breakCol(height, rand)
    val full = (col1 + col2).shuffled().toMutableList()

    // attempts to add the odd-piece (piece that won't be used)
    // however, this sometimes makes it possible to make higher columns!
    // comment this next line out to generate lists with all pieces used, strictly-known-height columns
    //full += if (rand.nextBoolean()) listOf(1 + rand.nextInt(full[rand.nextInt(full.size)])) else listOf()

    return ColumnData(full, col1, col2, height)
}

fun breakCol(height: Int, rand: Random): List<Int> {
    // modify these to get more "pieces" per column
    val pieceSizeMin =  Math.max(1, height / 50)
    val pieceSizeMinAdd = Math.max(1, height / 5)   // random num in range (0,pieceSizeMinAdd) gets added to the min piece size

    var remain = height
    val result = mutableListOf<Int>()
    while (remain > 0) {
        val piece = pieceSizeMin + rand.nextInt(pieceSizeMinAdd)
        if (remain - piece >= 0) {
            result.add(piece)
            remain -= piece
        } else {
            result.add(remain)
            remain = 0
        }
    }
    return result
}