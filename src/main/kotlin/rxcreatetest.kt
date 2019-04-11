//import io.reactivex.Observable
//import io.reactivex.Single
//import java.util.*
//
//fun main() {
//
//}
//
//
//fun findTopKElRev(list: List<Int>, k: Int): List<Int> {
//    val counts = mutableMapOf<Int, Int>()
//    val rct = mutableMapOf<Int, Int>()
//    var max = -1;
//
//    list.forEach { it: Int ->
//        val newCount = counts[it]?.plus(1) ?: 1
//        counts[it] = newCount
//        rct[newCount] = it
//    }
//
//    Single.create<Int> {
//        it.onError()
//    }
//
//}
//
//
//fun findTopKElements(list: List<Int>, k: Int): List<Int> {
//    val counts = mutableMapOf<Int, Int>()
//    val topK = LinkedList<Int>()
//    list.forEach {
//        counts[it] = counts[it]?.plus(1) ?: 1
//        var ind = 0
//        topK.remove(it)
//        topK.forEachIndexed { _, topEl ->
//            if (counts[it]!! > counts[topEl]!!) return@forEachIndexed
//            ind++
//        }
//        if (ind < k) topK.add(ind, it)
//        if (topK.size > k) topK.removeLast()
//    }
//    return topK
//}
//
//
//
