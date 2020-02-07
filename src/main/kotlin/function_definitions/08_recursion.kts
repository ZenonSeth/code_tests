package function_definitions



 //1 + 2 + 3 + .. + N

// tailrec fun sumOneToN(n: Int): Int {
//    return if (n <= 0) {
//        0
//    } else {
//        n + sumOneToN(n - 1)
//    }
//}
















tailrec fun sumOneToN(n: Int, ongoingSum: Int = 0): Int {
    return if (n <= 0) {
        0
    } else {
        sumOneToN(n - 1, ongoingSum + n)
    }
}
