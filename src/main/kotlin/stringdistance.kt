/**
 * Written by Milcho on 2/18/2019.
 */


fun main() {
    val s1 = "friend"
    var s2 = "enemy"
    println(findLongestCommonSubsequence(s1,s2))
    println(findCostToConvertStringAtoStringB(s1, s2))
    s2 = "g$s2"
    println("-")
    println(findLongestCommonSubsequence(s1,s2))
    println(findCostToConvertStringAtoStringB(s1, s2))
}


fun findCostToConvertStringAtoStringB(a: String, b: String) =
        (Math.max(a.length, b.length) - findLongestCommonSubsequence(a, b).length)


fun findLongestCommonSubsequence(str1: String, str2: String) =
        if (str1.length > str2.length) findLongestCommonSubsequenceStartingAt(str2, str1)
        else findLongestCommonSubsequenceStartingAt(str1, str2)


fun findLongestCommonSubsequenceStartingAt(shorter: String, longer: String, startingIndex: Int = 0): String {
    var latestIndexInLong = -1
    var longestStr = ""
    val alternatives = mutableListOf<String>()
    (startingIndex until shorter.length).forEach { i ->
        val indexInLonger = longer.indexOf(shorter[i], latestIndexInLong)
        if (indexInLonger > latestIndexInLong) {
            latestIndexInLong = indexInLonger
            longestStr += shorter[i]
        }
        if (indexInLonger >= 0)
            alternatives.add(findLongestCommonSubsequenceStartingAt(shorter, longer, i + 1))
    }
    alternatives.forEach {
        if (it.length > longestStr.length) longestStr = it
    }
    return longestStr
}