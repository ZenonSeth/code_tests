import java.util.*

fun circularArrayRotation(a: Array<Int>, k: Int, queries: Array<Int>): Array<Int> {
    // note: This actually accounts for K (the rotation) to be negative
    return queries.map {
        val index =
            if (it - k >= 0) (it - k) % a.size
            else ((it - k + 1) % a.size) + a.size - 1
        a[index]
    }.toTypedArray()
}

fun main(args: Array<String>) {
    while (true) {
        val scan = Scanner(System.`in`)

        val nkq = scan.nextLine().split(" ")
        if (nkq[0].isEmpty()) return

        val n = nkq[0].trim().toInt()

        val k = nkq[1].trim().toInt()

        val q = nkq[2].trim().toInt()

        val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val queries = Array<Int>(q, { it })
//    for (i in 0 until q) {
//        val queriesItem = scan.nextLine().trim().toInt()
//        queries[i] = queriesItem
//    }

        val result = circularArrayRotation(a, k, queries)

        println(result.joinToString("\n"))
    }
}
