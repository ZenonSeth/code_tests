package lakes


fun main(args: Array<String>) {
    val heightMap = getHeightMap()
    val lakeCounts = solveLakes(heightMap)
}

fun solveLakes(heightMap: Array<Array<Int>>): Int {
    if (heightMap.isEmpty()) return 0

    val mapW = heightMap.size
    val mapH = heightMap[0].size
    val lake = Array<Array<Int>>(mapW) { Array(mapH) {0} }
    var newLakeIndex = 1
    for (x in 0 until mapW)
    for (y in 0 until mapH) {
        val value = heightMap[x][y]
        val prevX = getLakeIndex(x - 1, y)
        val prevY = getLakeIndex(x, y - 1)
//        if (prevX = -1) {
//
//        }
    }
    return 0
}

fun getLakeIndex(i: Int, y: Int): Int {
return 0
}


fun getHeightMap(): Array<Array<Int>> {
    return arrayOf( arrayOf(0,1,0,0,0),
                    arrayOf(0,2,3,1,2),
                    arrayOf(1,0,0,1,1),
                    arrayOf(3,0,0,0,2),
                    arrayOf(2,1,2,0,2))
}

