package random

fun main(args: Array<String>) {
    val arrayA = arrayOf(1,2,3,4,5)
    val arrayB = arrayOf(4,2,2,2,5)
    arrayA * arrayB
    val mapIndexed = arrayA.mapIndexed { i, value -> value * arrayB[i] }
    println(mapIndexed);

}

private operator fun <T> Array<T>.times(arrayB: Array<T>) {
    
}

