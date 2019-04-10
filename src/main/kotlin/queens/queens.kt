package queens

import java.lang.Math.abs
import java.util.*
import kotlin.system.measureTimeMillis


//    for (boardSize in 1..14) {
//        var solveQueens : List<List<Int>>? = listOf()
//        val time = measureTimeMillis { solveQueens = solveQueens(mutableListOf(), 0, boardSize) }
//        solveQueens?.let {
//            println("(Time:${time}ms) Num solutions for board of size $boardSize = ${it.size}")
//            //printBoards(it, boardSize)
//        } ?: println("(Time:${time}ms) Num solutions for board of size $boardSize = 0")
//    }

fun main(args: Array<String>) {
    for (boardSize in 1..16) {
        var numSolutions = 0
        val time = measureTimeMillis { numSolutions = countQueens(boardSize) }
        println("(Time:${time}ms) Num solutions for board of size $boardSize = $numSolutions")
    }
}

fun solveQueens(boardState: List<Int>, row: Int, boardSize: Int): List<List<Int>>? {
    if (row >= boardSize) {
        return null
    }

    val solutions = mutableListOf<List<Int>>()
    for (col in 0 until boardSize) {
        if (canPlaceQueen(boardState, row, col)) {
            val copy = boardState.toMutableList()
            copy.add(col)
            solveQueens(copy, row + 1, boardSize)?.run { solutions.addAll(this) } ?: solutions.add(copy)
        }
    }
    return solutions
}

// entry point that initializes recursive function correctly, to simplify calling (just call this with board size)
fun countQueens(boardSize: Int): Int {
    return recursiveCountQueens(LinkedList(), 0, boardSize, (0 until boardSize).toSet())
}

fun recursiveCountQueens(boardState: LinkedList<Int>, row: Int, boardSize: Int, availableCols : Set<Int>): Int {
    if (row >= boardSize) return 1
    if (availableCols.isEmpty()) return 0

    var subSolutions = 0
    for (col in availableCols) {
        if (canPlaceQueen(boardState, row, col)) {
            boardState.add(col)
            subSolutions += recursiveCountQueens(boardState, row + 1, boardSize, availableCols.minus(col))
            boardState.removeLast()
        }
    }
    return subSolutions
}

fun canPlaceQueen(boardState: List<Int>, row: Int, col: Int): Boolean {
    boardState.forEachIndexed{qRow, qCol ->
        if ((col == qCol) || (row - qRow == abs(col - qCol))) return false
    }
    return true
}

fun printBoards(solutions: List<List<Int>>, boardSize: Int) {
    solutions.forEach{
        for (y in 0 until boardSize) {
            for (x in 0 until boardSize) {
                if (it[y] == x) {
                    print("Q ")
                } else {
                    print("_ ")
                }
            }
            println()
        }
        println()
    }
}
