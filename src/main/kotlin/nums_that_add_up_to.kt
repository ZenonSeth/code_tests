fun findNumbersThatAddUpTo(candidates: Set<Int>, target: Int): Set<List<Int>> {
    fun find_internal(cand: List<Int>, tar: Int, soFar: List<Int> = emptyList()): Set<List<Int>>? =
        when {
            tar < 0 -> null
            tar == 0 -> setOf(soFar)
            else -> candidates.fold(mutableSetOf<List<Int>>()) { solutions, entry ->
                if (entry <= soFar.lastOrNull() ?: Int.MAX_VALUE) {
                    find_internal(cand, tar - entry, soFar.plus(entry))
                        ?.let { result -> solutions.addAll(result) }
                }
                solutions
            }
        }
    return find_internal(candidates.toList().sorted(), target) ?: emptySet()
}


fun main() {
    val inputs = listOf(
        setOf(2, 4, 6, 7) to 7,
        setOf(2, 3, 5) to 8
    )
    inputs.forEach { (candidates, target) ->
        println(findNumbersThatAddUpTo(candidates, target))
    }
}