package stolennecklace

typealias NecklacePiece = MutableList<Char>

fun main(args: Array<String>) {

    //val input = mutableListOf('a', 'b', 'b', 'b', 'c', 'b', 'b', 'a', 'a', 'c', 'a', 'b')
    val input = ("aaffaaccbbbee77b".map { it }).toMutableList()
    println("Input: $input")
    val res = solveNecklace(input)
    input.forEachIndexed{ index, c -> if (res[index]) print(c) else print("_"); print(", ")}
    println()
    input.forEachIndexed{ index, c -> if (res[index]) print("_") else print(c); print(", ")}

}

//fun genStolenNecklace() : List<Char> {
//    val rand = Random()
//
//}

//Pair<MutableList<NecklacePiece>, MutableList<NecklacePiece>>

fun solveNecklace(necklace: NecklacePiece): List<Boolean> {
    val jewelCounts = mutableMapOf<Char, Int>()
    necklace.forEach { ch -> jewelCounts[ch]?.let { jewelCounts.set(ch, it+1) } ?: jewelCounts.set(ch, 1) }

    val split = Pair<MutableList<NecklacePiece>, MutableList<NecklacePiece>>(mutableListOf(), mutableListOf())
    split.first.add(mutableListOf())
    var numCuts = 0
    val ownerList = (1..necklace.size).map { false }.toMutableList()

    var currSplit = split.first
    necklace.forEachIndexed{ index, ch ->
        val maxCount = jewelCounts[ch]!! / 2
        if (countChars(currSplit, ch) < maxCount) {
            currSplit.last().add(ch)
            ownerList[index] = currSplit === split.first
        } else {
            currSplit = if (currSplit === split.first) split.second else split.first
            currSplit.add(mutableListOf(ch))
            ownerList[index] = currSplit === split.first
            numCuts++
        }
    }
    println(jewelCounts)
    println("num cuts = $numCuts")
    println("spit: $split")
    return ownerList

}

fun countChars(neckPieces: MutableList<NecklacePiece>, ch: Char): Int {
    var count = 0
    neckPieces.forEach { piece -> count += piece.count{ it == ch } }
    return count
}

