package random

fun main (args: Array<String>) {
    val input = listOf(80, 6, 1, 1)
    val target = 26
    println("Input = $input, target = $target")
    println("Solving backwards: ")
    solveNums(input, target)?.reversed()?.forEach { println(it) } ?: println("No solution found")
    println("Solving forward: ")
    solveNumsForward(input, target)?.forEach{ println(it) } ?: println("No solution found")
}

fun solveNums(nums: List<Int>, target: Int) = solveNumsRec(nums, target, listOf())
fun solveNumsRec(nums: List<Int>, target: Int, operations: List<Operation>): List<Operation>? {
    if (!operations.isEmpty()) {
        when (operations.last()) {
            is Operation.ADD -> if (target == 0) return operations.subList(0, operations.size - 1)
            is Operation.SUB -> if (target == 0) return operations.subList(0, operations.size - 1)
            is Operation.DIV -> if (target == 1) return operations.subList(0, operations.size - 1)
            is Operation.MUL -> if (target == 1) return operations.subList(0, operations.size - 1)
        }
    }

    if (nums.isEmpty()) { return null }
    for (num in nums) {
        val subNums = nums.minus(num)
        solveNumsRec(subNums, target - num, operations.plus(Operation.ADD(target - num, num, target)))?.run { return this }
        solveNumsRec(subNums, target + num, operations.plus(Operation.SUB(target + num, num, target)))?.run { return this }
        solveNumsRec(subNums, target * num, operations.plus(Operation.DIV(target * num, num, target)))?.run { return this }
        if (num != 0 && target % num == 0) {
            solveNumsRec(subNums, target / num, operations.plus(Operation.MUL(target / num, num, target)))?.let { return it }
        }
    }
    return null
}


fun solveNumsForward(nums: List<Int>, target: Int) = solveNumsForwardRec(nums, target, listOf(), 0)
fun solveNumsForwardRec(nums: List<Int>, target: Int, operations: List<Operation>, valueSoFar: Int) : List<Operation>? {
    if (valueSoFar == target) {
        return operations.subList(1, operations.size)
    }
    for (num in nums) {
        solveNumsForwardRec(nums.minus(num), target, operations.plus(Operation.ADD(valueSoFar, num, valueSoFar + num)), valueSoFar + num)?.run{ return this }
        solveNumsForwardRec(nums.minus(num), target, operations.plus(Operation.SUB(valueSoFar, num, valueSoFar - num)), valueSoFar - num)?.run{ return this }
        solveNumsForwardRec(nums.minus(num), target, operations.plus(Operation.MUL(valueSoFar, num, valueSoFar * num)), valueSoFar * num)?.run{ return this }
        if (num != 0) {
            solveNumsForwardRec(nums.minus(num), target, operations.plus(Operation.DIV(valueSoFar, num, valueSoFar / num)), valueSoFar / num)?.run { return this }
        }
    }
    return null
}

sealed class Operation(val a: Int, val b: Int, val res: Int) {
    class ADD(a: Int, b: Int, res: Int) : Operation(a, b, res) {
        override fun toString(): String = super.toString().replace('X', '+')
    }
    class SUB(a: Int, b: Int, res: Int) : Operation(a, b, res) {
        override fun toString(): String  = super.toString().replace('X', '-')
    }
    class DIV(a: Int, b: Int, res: Int) : Operation(a, b, res) {
        override fun toString(): String  = super.toString().replace('X', '/')
    }
    class MUL(a: Int, b: Int, res: Int) : Operation(a, b, res) {
        override fun toString(): String  = super.toString().replace('X', '*')
    }
    override fun toString(): String  = "$a X $b = $res"
}


