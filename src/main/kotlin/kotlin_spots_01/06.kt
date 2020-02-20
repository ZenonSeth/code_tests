package kotlin_spots_01

/****************************************************************
 *  06
 ****************************************************************/

fun printNumberSign(num: Int): Any =
    if (num < 0) {
        "negative"
    } else if (num > 0) {
        "positive"
    } else {
        "zero"
    }.let { println(it) }



fun main() {
    printNumberSign(-2)
    printNumberSign(0)
    printNumberSign(2)
}

/**
 * What will it print?
 * a) negative; zero; positive
 * b) negative; zero
 * c) negative; positive
 * d) zero; positive
 */