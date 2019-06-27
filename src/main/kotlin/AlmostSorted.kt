/*
 *
 *
 *  NOTE: This is only an attempt at a solution, not a working solution (yet)
 *
 *
 */

fun List<Int>.isNonDecreasing(): Boolean {
    forEachIndexed { i, v -> if (i != 0 && v < this[i - 1]) return false }
    return true
}

// Complete the almostSorted function below.
fun almostSorted(arr: Array<Int>): Unit {
    if (arr.isEmpty()) println("yes")

    var prev = arr[0]
    val splits: MutableList<MutableList<Int>> = mutableListOf(mutableListOf())
    var inADecreasingSeq = false

    arr.forEachIndexed { i, v ->
        if (v >= prev) {
            if (!inADecreasingSeq) {
                splits.last().add(v)
            } else {
                splits.add(mutableListOf(v))
            }
        } else {
            if (inADecreasingSeq) {
                splits.last().add(v)
            } else {
                val p = splits.last().last()
                if (p > v) {
                    splits.last().removeAt(splits.last().size - 1)
                    splits.add(mutableListOf(p, v))
                } else {
                    splits.add(mutableListOf(v))
                }
            }
        }
        if (splits.last().size == 2) {
            inADecreasingSeq = splits.last().last() < splits.last().first()
        }
        prev = v
    }
    println(splits)
    splits.forEach { println(it.isNonDecreasing()) }
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//    val n = scan.nextLine().trim().toInt()
//    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val arr = arrayOf(

        // 1, 2, 3, 4, 5

        1, 5, 19, 12, 13, 6, 20

        // 0, 5, 15, 14, 13, 12, 11, 10, 20, 25
    )

    almostSorted(arr)
}
