/*

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note: All numbers (including target) will be positive integers.
      The solution set must not contain duplicate combinations.

Example 1
    Input: candidates = [2,3,6,7], target = 7
    Solution set is: [[7], [2,2,3]]

Example 2
    Input: candidates = [2,3,5], target = 8
    Solution set is: [[2,2,2,2], [2,3,3], [3,5]]

*/

























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