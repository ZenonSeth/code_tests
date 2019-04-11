import java.lang.Math.pow
import java.math.BigDecimal
import kotlin.random.Random

/**
 *
 */

fun main() {
    val res = getRandList(System.nanoTime())
//    println(res)
//    println(findTopK(res, 5))


    println(pow(2.0, 54.0) + 3.0 - pow(2.0, 54.0))
    println(Double.MAX_VALUE)
    println(pow(2.0, 54.0))
    println(0.3 + 0.6)

    val zeroPointOne = "0001100110011001100110011001100110011001100110011001101"
    val addedZeroPointOne = binDecimalStrToBigDec(zeroPointOne)
    println(addedZeroPointOne)
    println(addedZeroPointOne.plus(addedZeroPointOne))
}



fun binDecimalStrToBigDec(str: String) : BigDecimal {
    var res = BigDecimal.ZERO
    str.forEachIndexed { index, c ->
        if (c == '1') {
            res = res.add(BigDecimal.ONE.divide(BigDecimal.valueOf(longPow(2L, index.toLong() + 1))))
        }
    }
    return res
}

fun longPow(a: Long, b: Long): Long {
    var res = 1L
    (1..b).forEach{ res *= a }
    return res
}


fun getRandList(seed: Long): List<Int> {
    val rand = Random(seed)
    return (0..(10+rand.nextInt()%100)).map { rand.nextInt() % 10 }
}

fun findTopK(input: List<Int>, K: Int): List<Int> {
    println("input size = ${input.size}")
    var counter = 0

    val counts = mutableMapOf<Int, Int>()
    input.forEach {
        counts[it] = counts[it]?.plus(1) ?: 1
        counter++
    }

    val counts2 = mutableMapOf<Int, List<Int>>()
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    counts.forEach { key, v ->
        min = if (v < min) v else min
        max = if (v > max) v else max
        counts2[v] = counts2[v]?.plus(key) ?: listOf(key)
        counter++
    }

    val topk = mutableListOf<Int>()
    for (i in max downTo min) {
        if (topk.size >= K) {
            println("iteration counter = $counter")
            return topk
        }
        counts2[i]?.let { topk.addAll(it) }
        counter++
    }
    println("iteration counter = $counter")
    return topk
}


