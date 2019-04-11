import java.util.*
import kotlin.math.log


var rand = Random()
fun main2() {
    rand = Random(133)
    printDistribution(::robrand, 17, 2_000_000)
    println()
    rand = Random(133)
    printDistribution(::myRand, 17, 2_000_000)

}

fun printDistribution(randFunc: (Int)->Int, targetVal: Int, numTrials: Int = 100_000) {
    val els = HashMap<Int, Int>()
    (1..numTrials).forEach{
        val a = randFunc(targetVal)
        els[a] = els[a]?.plus(1) ?: 1
    }
    (0 until targetVal).forEach {
        val percent = 100.0 * (els[it]?:0).toDouble() / numTrials.toDouble()
        var numLines = 2 * Math.round(percent).toInt()
        numLines = if (numLines == 0) 1 else numLines
        print("$it:\t")
        (1..numLines).forEach{print("|")}
        println(" : $percent%")
    }
}

fun rand5() : Int {
    return rand.nextInt(5)
}


fun myRand(n: Int): Int {
    val numBits = Math.floor(log(n.toDouble(), 2.0)).toInt() + 1
    var sum = n + 1
    while (sum >= n) {
        sum = 0
        (0 until numBits).forEach{ i ->
            var roll = rand5()
            while (roll == 4) { roll = rand5() }
            sum += (roll and 1) shl i
        }
    }
    return sum
}

tailrec fun robrand(n: Int): Int {
    var currentTotal = 0
    (0..Integer.toBinaryString(n).lastIndex).forEachIndexed { index, b ->
        var newTotal = currentTotal
        while (true) {
            val randValue = rand5()
            if (randValue != 0) {
                if (randValue % 2 == 0) {
                    newTotal = newTotal or (1 shl index)
                }
                break
            }
        }
        currentTotal = newTotal
    }
    if (currentTotal >= n) {
        // Breach of max, retry
        return robrand(n)
    }
    return currentTotal
}


fun main() {
    printDistribution(::bencerand, 13)
}

fun bencerand(n: Int) : Int {
    val numDim = Math.floor(log(n.toDouble(), 5.0)).toInt() + 1
    var num = n + 1
    while (num >= n) {
        num = lookup((1..numDim).map { rand5() })
    }
    return num
}


fun lookup(list: List<Int>) : Int {
    var sum = 0
    var mult = 1
    list.forEach{
        sum += it * mult
        mult *= 5
    }
    return sum
}