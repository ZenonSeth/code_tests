import java.util.*

/**
 * Written by Milcho on 12/19/2018.
 */

fun main() {
    //val input = listOf(1,2,2,3,3,3,3,4,4,4)
    val input = listOf(1,2,2,3,3)
    val k = 2
    val res = findTopKElements(input, k)
    println("Top $k from Input list: $input = $res")
}


fun findTopKElements(list: List<Int>, k: Int): List<Int> {
    val counts = mutableMapOf<Int, Int>()
    val topK = LinkedList<Int>()
    list.forEach {
        counts[it] = counts[it]?.plus(1) ?: 1
        var ind = 0
        topK.remove(it)
        topK.forEachIndexed { _, topEl ->
            if (counts[it]!! > counts[topEl]!!) return@forEachIndexed
            ind++
        }
        if (ind < k) topK.add(ind, it)
        if (topK.size > k) topK.removeLast()
    }
    return topK
}

