import java.util.*

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var height = 0
    var lastDirUp = false
    var valleycount = 0
    s.forEach {
        if (it == 'U') {
            height++
            lastDirUp = true
        } else {
            height--
            lastDirUp = false
        }
        if (height == 0 && lastDirUp == true) {
            valleycount++
        }
    }
    return valleycount
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
