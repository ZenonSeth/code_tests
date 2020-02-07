
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt


@JvmName("hel")

fun milchop_sqrt(number: Double, epsilon: Double): Double {
    if (number < 0.0) return Double.NaN
    if (number == 0.0) return 0.0
    var error: Double
    var guess = number / 2
    do {
        val divByGuess = number / guess
        error = abs(divByGuess - guess)
        guess = (guess + divByGuess) / 2.0
    } while (error > epsilon)
    return guess
}

class varTest() {
    var a: String = "adsf"
        private set(v: String) {
            field = v
        }
        get() = ""
}

fun milchop_rootN(root: Int, number: Double, epsilon: Double = 1E-4): Double {
    when {
        number < 0.0 -> return Double.NaN
        number == 0.0 -> return 0.0
        root <= 0 -> return Double.NaN
        root == 1 -> return number
    }
    var error: Double
    var guess = number / root
    do {
        var divByGuess: Double = number
        repeat(root - 1) { divByGuess /= guess }
        error = abs(divByGuess - guess)
        guess = ((root - 1) * guess + divByGuess) / root
    } while (error > epsilon)
    return guess
}


fun main() {
    val number = 81.0
    val realSqrt = sqrt(number)
    val epsilon = 0.1
    val mySqrt = milchop_sqrt(number, epsilon)
    println("Real sqrt = $realSqrt")
    println("My sqrt   = $mySqrt")
    println("epsilon  = $epsilon")
    println("my error = ${abs(mySqrt - realSqrt)}")
    println("--------")
    val testVal = 1024.0
    (2..15).forEach {
        println("taking ${it}th root of $testVal")
        val myRoot = milchop_rootN(it, testVal)
        val mathRoot = testVal.pow(1.0 / it)
        println("my root   = $myRoot")
        println("real root = $mathRoot")
        println("diff = ${abs(mathRoot - myRoot)}\n")
    }
}