import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    var str1 = "aabccdee"
    var str2 = "aacffgee"
    str1 = "aabsdfhccdhdee"
    str2 = "aachdffgefhdf"
    findLongestCommonSubsequenceStartingAt(str1, str2).forEach {
        println(it)
    }
    println("cost = ${findCostToConvertStringAtoStringB(str1, str2)}")
}


/*

    aabsdfhccdhdee
    aachdffgefhdf



 */

/*
    aacffgee    +b      1
    aabcffgee   f->c    1
    aabccfgee   -f      1
    aabccgee    g->d    1

    aabccdee


    aacffgee
    aac   ee

    aa c  ee
    aabccdee
 *
 */


data class DistCh(val ch: Char, var d1: Int = 0, var d2: Int = 0)
typealias DistStr = ArrayList<DistCh>

fun findCostToConvertStringAtoStringB(a: String, b: String): Int {
    val s = findLongestCommonSubsequenceStartingAt(a, b)
    var cost = Int.MAX_VALUE
    var minStr: DistStr = DistStr()
    s.forEach { str ->
        var strCost = 0
        str.forEach {
            strCost += abs(it.d1 - it.d2) + max(min(it.d1, it.d2),0)
        }
        cost = min(cost, strCost)
        if (cost == strCost) minStr = str
    }
    println("--$minStr")
    return cost
}

fun findLongestCommonSubsequenceStartingAt(A: String, B: String, startingIndex: Int = 0): List<DistStr> {
    val longer = if (A.length > B.length) A else B
    val shorter = if (A.length > B.length) B else A
    var latestIndexInLong = -1
    var latestIndexInShort = -1
    val longestStr = DistStr()
    var alternatives = mutableListOf<DistStr>()
    (startingIndex until shorter.length).forEach { i ->
        val indexInLonger = longer.indexOf(shorter[i], latestIndexInLong + 1)
        if (indexInLonger > latestIndexInLong) {
            longestStr.add(DistCh(
                    shorter[i],
                    max(0,i - max(0,latestIndexInShort) - 1),
                    max(0, indexInLonger - max(0,latestIndexInLong) - 1)))
            latestIndexInLong = indexInLonger
            latestIndexInShort = i
        } else if (indexInLonger >= 0)
            alternatives.addAll(findLongestCommonSubsequenceStartingAt(shorter, longer, i + 1))
    }

    if (longestStr.isNotEmpty()) {
        longestStr.add(DistCh(
                '|', max(0,shorter.length - latestIndexInShort - 2),
                max(0, longer.length - latestIndexInLong - 1)))
        alternatives.add(longestStr)
    }
    return alternatives
}

//class UseCase {
//
//    fun find(needle: String, haystack: String): Int {
//
//    }
//
//    infix fun place(needle: String): {
//
//    }
//
//    infix fun find(needle: String): UseCase {
//
//    }
//
//    infix fun inside(haystack: String): String {
//
//    }
//}
//
