import java.math.BigInteger

fun main() {
//    val n = findFibRepeatingPoint()
//    println("Fib starts repeating at: $n)")
//    println("Starting at n: ")
//    ((n.first - 1)..(n.first + 10)).forEach {
//        println("fib($it) = ${fibn(it)}")
//    }


    (0..1000).forEach {
        println("fib($it) = ${fibn(it).mod(BigInteger.valueOf(100))}")
    }




}


fun findFibRepeatingPoint(): Pair<Int, List<Int>> {
    val seq = mutableListOf(0, 1)
    var found = false
    var index = 2
    var fIndex = -1
    while (!found) {
        val newInt = (seq[seq.size - 1] + seq[seq.size - 2]) % 100
        fIndex = seq.indexOf(newInt)
        if (fIndex >= 1 && fIndex < seq.size - 2) {
            //val nextInt = (newInt + seq[seq.size - 1]) % 100
            if (seq[fIndex - 1] == seq.last()) {
                found = true
                seq.add(newInt)
            }
        }
        if (index % 10 == 0) println("Checking $index, seq = $seq")
        seq.add(newInt)
        index++
    }
    return Pair(index, seq.subList(fIndex, seq.size))
}


fun fibn(n: Int): BigInteger {
    if (n <= 1) return BigInteger.valueOf(n.toLong())
    var a = BigInteger.ZERO
    var b = BigInteger.ONE
    (1 until n).forEach { _ ->
        val t = a.plus(b)
        a = b
        b = t
    }
    return b
}