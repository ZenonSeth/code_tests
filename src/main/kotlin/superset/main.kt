package superset



fun main(args: Array<String>) {

    val myset = setOf(1,2,3,4)
    println("input size: $myset")
    val out = setToSets(myset);
    println("output size: $out")

    val ar = arrayOf<Int>()

}


fun <T> superset(input: Set<T>): Set<Set<T>> {
    var inputAsList = input.toList()
    val result = mutableSetOf<Set<T>>(emptySet())
    for (i in 1..input.size) result.addAll(subsetsOfSize(i, inputAsList))
    return result
}

fun <T> subsetsOfSize(subsetSize: Int, input: List<T>): Set<Set<T>> {
    val result: MutableSet<Set<T>> = HashSet()
    if (subsetSize <= 1) {
        input.forEach { result.add(setOf(it)) }
    } else {
        for (i in 0 until (input.size - subsetSize) + 1) {
            val subsequentSubsets = subsetsOfSize(subsetSize - 1, input.subList(i + 1, input.size))
            subsequentSubsets.forEach { result.add(setOf(input[i]).plus(it)) }
        }
    }
    return result
}

fun <T> setToSets(input: Set<T>): Set<Set<T>> {
    val newSet = mutableSetOf<Set<T>>()
    newSet += input
    newSet += emptySet<T>()
    if (input.count() > 1) {
        input.forEach {
            newSet += setToSets(input.minus(it))
        }
    }
    return newSet
}