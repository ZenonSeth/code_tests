
fun main() {
    val weights = listOf(10.0, 40.0, 20.0, 30.0)
    val values = listOf(60.0, 40.0, 100.0, 120.0)
    val capacity = 50.0

    println("Maximum value we can obtain = ${getMaxValue(weights, values, capacity)}")
}

data class KItem(val weight: Double, val value: Double) { val cost = value / weight }

operator fun KItem.plus(other: KItem) = KItem(weight + other.weight, value + other.value)

private fun getMaxValue(weights: List<Double>, values: List<Double>, capacity: Double) =
    values

        .mapIndexed { index, value -> KItem(weights[index], value) }

        .sortedWith(Comparator { c1, c2 -> c2.cost.compareTo(c1.cost) })

        .fold(KItem(0.0, 0.0)) { acc, item ->
            when {
                capacity - acc.weight - item.weight >= 0 ->
                    KItem(item.weight, item.value)
                capacity - acc.weight > 0 ->
                    KItem(capacity, item.value * ((capacity - acc.weight) / item.weight))
                else ->
                    return@fold acc
            } + acc
        }

        .value


inline fun <T, R> Iterable<T>.foldUntil(
    initial: R, operation: (acc: R, T) -> R,
    condition: (acc: R)->Boolean): R {
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        if (condition(accumulator)) break
    }
    return accumulator
}











