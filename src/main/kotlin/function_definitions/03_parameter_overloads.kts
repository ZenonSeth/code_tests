package function_definitions

import java.math.BigDecimal




fun addTwo(a: Int, b: Int) = a + b


fun addTwo(a: Int) = addTwo(a, 2)



















@JvmOverloads
fun aSmarterAddTwo(a: Int = 2, b: Int = 2) = a + b



















fun binarySearch(array: Array<Int>, startIndex: Int = 0, endIndex: Int = array.size) {
    // imagine a binary search here
}























