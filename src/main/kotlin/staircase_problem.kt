/*
There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.

Given N, write a function that returns the number of unique ways you can climb the staircase.
The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */


fun main() {
    val numStairs = 3
    val allowedSteps = setOf(1,2)
    println(findStaircaseSolutions(numStairs, allowedSteps,false).size)
//    println(findStaircaseSolutionsLoop(numStairs, allowedSteps).size)
    println(staircaseProblemSolveRob(numStairs))
}

// first solution - using recursion

fun findStaircaseSolutions(
    numStairs: Int,
    allowedSteps: Set<Int>,
    uniqueOnly: Boolean = true,
    prevSolutions: Set<List<Int>> = emptySet(),
    currentSteps: List<Int> = emptyList(),
    lastUsedStep: Int? = null
): Set<List<Int>> {
    var solutions = prevSolutions.toMutableSet()
    allowedSteps.forEach {
        if (it == numStairs && it <= (lastUsedStep ?: it)) {
            solutions.add(currentSteps + it)
        } else if (it < numStairs && it <= (lastUsedStep ?: it)) {
            solutions = findStaircaseSolutions(
                numStairs - it,
                allowedSteps,
                uniqueOnly,
                solutions,
                currentSteps + it,
                if (uniqueOnly) it else null
            ).toMutableSet()
        }
    }
    return solutions
}

fun staircaseProblemSolveRob(n: Int): Int {
    require(n > 0) { "Int |n| must be non-zero non-negative. n=$n" }
    return when (n) {
        1 -> 1
        2 -> 1 + staircaseProblemSolveRob(1)
        else -> staircaseProblemSolveRob(n - 1) + staircaseProblemSolveRob(n - 2)
    }
}


// 2nd solution - using a loop

fun findStaircaseSolutionsLoop(
    numStairs: Int,
    allowedSteps: Set<Int>,
    uniqueOnly: Boolean = true
): Set<List<Int>> {
    val steps = allowedSteps.sorted()
    var mults = allowedSteps.map { 0 }
    val solutions = mutableSetOf<List<Int>>()
    while (true) {
        if (mults.last() * steps.last() > numStairs) return solutions
        if (sumOf(mults, steps) == numStairs) solutions.add(getStepsAsList(mults, steps))
        mults = incrementMultipliers(mults, steps, numStairs)
    }
}

fun incrementMultipliers(mults: List<Int>, steps: List<Int>, numStairs: Int): List<Int> {
    var prevIncremented = true
    return mults.mapIndexed { i, mult ->
        when {
            !prevIncremented -> mult
            i == mults.size - 1 || (mult + 1) * steps[i] <= numStairs -> (mult + 1).also { prevIncremented = false }
            else -> 0.also { prevIncremented = true }
        }
    }
}

fun getStepsAsList(mults: List<Int>, steps: List<Int>): List<Int> =
    steps.mapIndexed { index, step -> List(mults[index]) { step } }.flatten()

fun sumOf(mults: List<Int>, steps: List<Int>) = (0 until mults.size).sumBy { mults[it] * steps[it] }

