package twocolumns

import java.util.*

fun main(args: Array<String>) {
    val rand = Random()
    val numSets = 8
    (1..numSets).forEach { _ ->
        val data = genColData(rand)
        println("${data.input}\n = ${data.height} : ${data.lCol} + ${data.rCol}\n")
    }

}

data class ColumnData(val input: List<Int>, val rCol: List<Int>, val lCol: List<Int>, val height: Int)

fun genColData(rand: Random = Random(), targetHeight: Int = -1, minPieceSizeFraction: Int = -1): ColumnData {
    val height = if (targetHeight > 0) {targetHeight} else {8 + rand.nextInt(64)}
    val col1 = breakCol(height, rand, minPieceSizeFraction)
    val col2 = breakCol(height, rand, minPieceSizeFraction)
    val full = (col1 + col2).shuffled().toMutableList()

    // attempts to add the odd-piece (piece that won't be used)
    // however, this sometimes makes it possible to make higher columns!
    // comment this next line out to generate lists with all pieces used, strictly-known-height columns
    full += if (rand.nextBoolean()) listOf(1 + rand.nextInt(full[rand.nextInt(full.size)])) else listOf()

    return ColumnData(full, col1, col2, height)
}

fun breakCol(height: Int, rand: Random, minPieceSizeFraction: Int): List<Int> {
    // modify these to get more "pieces" per column
    val minFrac = if (minPieceSizeFraction <= 0) 5 else minPieceSizeFraction
    val pieceSizeMin =  Math.max(1, height / minFrac)
    val pieceSizeMinAdd = Math.max(1, height / minFrac)

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
