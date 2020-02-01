/**
 * Written by Milcho on 2/1/2020.
 */


class RN(val value: Int, val numeral: Char)

val numerals = listOf(RN(1000, 'M'), RN(500, 'D'), RN(100, 'C'), RN(50, 'L'), RN(10, 'X'), RN(5, 'V'), RN(1, 'I'))


fun int_to_roman(number: Int): String {
    fun romanize(number: Int, sigDig: Int, maxSym: String, halfSym: String, singleSym: String): String {
        val digit = number / sigDig - number / (sigDig * 10) * 10
        return when {
            digit >= 9 -> singleSym + maxSym
            digit >= 5 -> halfSym + singleSym.repeat(digit - 5)
            digit == 4 -> singleSym + halfSym
            else -> singleSym.repeat(digit)
        }
    }
    return "M".repeat(number / 1000) +
            romanize(number, 100, "M", "D", "C") +
            romanize(number, 10, "C", "L", "X") +
            romanize(number, 1, "X", "V", "I")
}

fun testRomanNumeralConversion(functionToTest: (Int) -> String) {
    listOf(5 to "V", 9 to "IX", 12 to "XII", 16 to "XVI", 29 to "XXIX", 44 to "XLIV", 45 to "XLV", 68 to "LXVIII", 83 to "LXXXIII", 97 to "XCVII", 99 to "XCIX", 500 to "D", 501 to "DI", 649 to "DCXLIX", 798 to "DCCXCVIII", 891 to "DCCCXCI", 1000 to "M", 1004 to "MIV", 1006 to "MVI", 1023 to "MXXIII", 2014 to "MMXIV", 3999 to "MMMCMXCIX")
        .map { entry ->
            val obtained = functionToTest(entry.first)
            if (obtained != entry.second)
                true.also { println("Error: Input of ${entry.first} expected ${entry.second} but got $obtained") }
            else false
        }.firstOrNull { it } ?: println("Your function passed all test cases!")
}

fun main() {
    testRomanNumeralConversion(::int_to_roman)
}