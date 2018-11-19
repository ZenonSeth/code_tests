package twocolumns

/**
 * Written by Milcho on 11/18/2018.
 */


/**
fun solveTwoColumns(input: List<Int>): Int {
val mList = input.toMutableList()
mergeSort(mList)
mList.reverse()
println(mList)

var col1 = LinkedList<Int>()
var col2 = LinkedList<Int>()
var sum1 = 0
var sum2 = 0
mList.forEach{
if (sum1 <= sum2) {
col1.add(it)
sum1 += it
} else {
col2.add(it)
sum2 += it
}
}

if (sum1 != sum2) {
balanceColumns(col1, col2, sum1, sum2)?.let {
col1 = it.first
col2 = it.second
}
}

println("$sum1 : $col1")
println("$sum2 : $col2")
return col1.sum()
}

fun balanceColumns(_col1: LinkedList<Int>, _col2: LinkedList<Int>, _sum1: Int, _sum2: Int): Pair<LinkedList<Int>, LinkedList<Int>>? {
// assign smaller to col2

val col1 = if (_sum1 >= _sum2) _col1 else _col2
val col2 = if (_sum1 < _sum2) _col1 else _col2

var sum1 = col1.sum()
var sum2 = col2.sum()

var balanced = sum1 == sum2
//    while (!balanced) {
val balancedCol1 = tryRemoveItemsFrom(col1, sum1, sum2)
if (balancedCol1 != null) {
return Pair(balancedCol1, col2)
}

balanced = sum1 == sum2
//    }
return null
}

fun tryRemoveItemsFrom(col1: LinkedList<Int>, startingSum: Int, targetSum: Int): LinkedList<Int>? {
val diff = startingSum - targetSum
val sumLists = mutableListOf(mutableListOf<Int>())

col1.forEach{colValue ->
if (colValue == diff) {
col1.remove(colValue)
return col1
}
if (colValue < diff) {
sumLists.forEach{sumList ->
val sumListSum = sumList.sum()
if (sumListSum + colValue == diff) {
col1.removeAll(sumList)
col1.remove(colValue)
return col1
}
if (sumListSum + colValue < diff) {
sumList.add(colValue)
}
}
}
}
return null
}


fun mergeSort(list: MutableList<Int>, start: Int = 0, end: Int = list.size) {
val size = end - start
if (size <= 1) return
if (size == 2) {
if (list[start] > list[end - 1]) Collections.swap(list, start, end - 1)
return
}

val start2 = start + (size) / 2 + (size % 2)
mergeSort(list, start, start2)
mergeSort(list, start2, end)
var i1 = start
var i2 = start2
val res = MutableList(size) { 0 }
for (i in 0 until size) {
if (i1 >= start2 || (i2 < end && list[i1] > list[i2])) {
res[i] = list[i2]
i2++
} else {
res[i] = list[i1]
i1++
}
}
(start until end).forEach { list[it] = res[it - start] }
}



 */
