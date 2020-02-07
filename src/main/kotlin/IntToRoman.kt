val numeralsList: List<Pair<Int, Char>> = listOf(
    1000 to 'M',
    500 to 'D',
    100 to 'C',
    50 to 'L',
    10 to 'X',
    5 to 'V',
    1 to 'I'
)

fun intToRoman(value: Int, prefix: String = ""): String {
    tailrec fun Char.repeated(n: Int, s: String = ""): String = if (n == 0) s else repeated(n - 1, "$s$this")
    fun String.minusLast(n: Int) = substring(0, length - n)
    numeralsList.forEachIndexed { index, numPair ->
        if (value >= numPair.first) {
            return if (index > 0 && prefix.endsWith(numPair.second.repeated(3))) {
                intToRoman(
                    value - numPair.first,
                    prefix.minusLast(3) + numPair.second + numeralsList[index - 1].second
                )
            } else {
                intToRoman(value - numPair.first, prefix + numPair.second)
            }
        }
    }
    return prefix
}

fun main() {
    val toTest = listOf(3, 4, 9, 58, 1984)
    toTest.forEach {
        println("$it to roman = ${intToRoman(it)}")
    }
}