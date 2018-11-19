package threemod

import java.util.*
import kotlin.system.measureTimeMillis

typealias ITriple = Triple<Int, Int, Int>


fun main(a: Array<String>) {

    getData(System.currentTimeMillis(), 8).forEach {

        var userSolution: Collection<ITriple> = listOf()
        val userTime = measureTimeMillis { userSolution = findTriplets(it.second, it.first) }
        var bruteForceSolution: Collection<ITriple> = listOf()
        val bruteTime = measureTimeMillis { bruteForceSolution = bruteForceFindTriplets(it.second, it.first) }
        val areEqual = areEqual(bruteForceSolution, userSolution)

        print("List size of ${it.second.size} | ")
        println("Brute time = $bruteTime; User time = $userTime")
        if (!areEqual) {
            println("--------- ERROR: User solution NOT equal to brute force!")
            println("Input v=${it.first}, list=${it.second}")
            println("User:  $userSolution")
            println("Brute: $bruteForceSolution")
            println("---------")
        }
    }
}


fun getDataS(): List<Pair<Int, List<Int>>> {
    return listOf(Pair(5, listOf(0, 1, 2, 4, 5)))
}

fun getData(seed: Long, numLists: Int, initialSize: Int = 16): List<Pair<Int, List<Int>>> {
    val rand = Random(seed)
    val results = mutableListOf<Pair<Int, List<Int>>>()

    var size = initialSize

    (0 until numLists).forEach { _ ->
        val list = mutableListOf<Int>()
        val valuesUpperBound = size * 2
        (0 until size).forEach { _ ->
            var add = rand.nextInt(valuesUpperBound * 2)
            while (list.contains(add)) {
                add = rand.nextInt(valuesUpperBound * 2)
            }
            list.add(add)
        }
        size += 128
        val ia = rand.nextInt(list.size)
        val ib = rand.nextInt(list.size)
        val ic = rand.nextInt(list.size)
        results.add(Pair(list[ia] + list[ib] + list[ic], list))
    }
    return results
}


fun areEqual(a: Collection<ITriple>, b: Collection<ITriple>): Boolean {
    if (a.size != b.size) return false
    a.forEach { tA ->
        val matchFound = b.firstOrNull { tB ->
            (tA.first == tB.first && tA.second == tB.second && tA.third == tB.third)
                    || (tA.first == tB.first && tA.second == tB.third && tA.third == tB.second)
                    || (tA.first == tB.second && tA.second == tB.first && tA.third == tB.third)
                    || (tA.first == tB.second && tA.second == tB.third && tA.third == tB.first)
                    || (tA.first == tB.third && tA.second == tB.first && tA.third == tB.second)
                    || (tA.first == tB.third && tA.second == tB.second && tA.third == tB.first)
        } != null
        if (!matchFound) return false
    }
    return true
}

fun bruteForceFindTriplets(list: List<Int>, value: Int): Collection<ITriple> {
    val results = mutableSetOf<ITriple>()
    for (i in 0 until list.size) {
        for (j in i + 1 until list.size) {
            for (k in j + 1 until list.size) {
                if ((list[i] + list[j] + list[k]) % value == 0) {
                    results.add(ITriple(list[i], list[j], list[k]))
                }
            }
        }
    }
    return results
}

fun findTriplets(list: List<Int>, value: Int): Collection<ITriple> {
    val results = mutableSetOf<ITriple>()
    for (i in 0 until list.size) {
        val a = list[i]
        val map: MutableMap<Int, MutableList<Int>> = HashMap()
        for (j in i + 1 until list.size) {
            val b = list[j]
            val modSum = a%value + b%value
            val expected1 = value - modSum
            val expected2 = value * 2 - modSum
            map[expected1]?.forEach { results.add(ITriple(a, b, it)) }
            map[expected2]?.forEach { results.add(ITriple(a, b, it)) }
            map.addToMap(b % value, b)
        }
    }
    return results
}


/*
data class ITriple(val first: Int, val second: Int, val third: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is ITriple) return false
        val listA = listOf(other.first, other.second, other.third).sorted()
        val listB = listOf(this.first, this.second, this.third).sorted()
        return listA[0] == listB[0] && listA[1] == listB[1] && listA[2] == listB[2]
    }

    override fun hashCode(): Int {
        return first + second + third
    }

    override fun toString(): String {
        return "($first,$second,$third)"
    }
}
*/

fun MutableMap<Int, MutableList<Int>>.addToMap(key: Int, value: Int) {
    if (this[key] != null) {
        this[key]?.add(value)
    } else {
        this[key] = mutableListOf(value)
    }
}

/*

fun findTripletsblarg(list: List<Int>, value: Int): List<ITriple> {
    val results = mutableListOf<ITriple>()

    val mods = mutableMapOf<Int, MutableList<Int?>>()
    list.forEach { mods.addToList(it%value, it) }
    val modsAsList = mods.toList()
    val availableTripletMods = mutableSetOf<ITriple>()

    for (i in 0 until modsAsList.size) {
        val a = modsAsList[i].first
        for (j in i + 1 until modsAsList.size) {
            val b = modsAsList[j].first
            val c1 = value-a-b
            val c2 = value*2-a-b
            if (mods[c1] != null) availableTripletMods.add(ITriple(a,b,c1))
            if (mods[c2] != null) availableTripletMods.add(ITriple(a,b,c2))
        }
    }
    availableTripletMods.forEach { modTriplet ->
        val listA = mods[modTriplet.first]!!
        val listB = mods[modTriplet.second]!!
        val listC = mods[modTriplet.third]!!
        for (i in 0 until listA.size) {
            val a = listA[i]
            listA[i] = null
            for (j in 0 until listB.size) {
                val b = listB[j]
                listB[j] = null
                for (k in 0 until listC.size) {
                    val c = listC[k]
                    if (b != null && c != null) {
                        results.add(ITriple(a!!,b,c))
                    }
                }
                listB[j] = b
            }
            listA[i] = a
        }

    }



    return results
}


fun MutableMap<Int, MutableList<Int?>>.addToList(key: Int, value: Int) {
    this[key]?.add(value) ?: this.put(key, mutableListOf(value))
}

*/

// something....
/*

    for (i in 0 until mappedAsList.size - 1) {
        val a = mappedAsList[i].first
        for (j in i + 1 until mappedAsList.size) {
            val b = mappedAsList[j].first
            val expected1 = value-a-b
            val expected2 = value*2-a-b
            val ex1ModTrip = ITriple(expected1, mappedAsList[i].first, mappedAsList[j].first)
            if (map[expected1] != null && coveredMods.firstOrNull{it.eq(ex1ModTrip)} == null) {
                coveredMods.add(ex1ModTrip)
                map[expected1]?.remove(a)
                map[expected1]?.remove(b)
                map[expected1]?.forEach { c ->
                    val trip = ITriple(a, b, c)
                    /*results.firstOrNull{it.eq(trip)} ?: */results.add(trip)
                }
                map[expected1]?.add(a)
                map[expected1]?.add(b)
            }

            val ex2ModTrip = ITriple(expected2, mappedAsList[i].first, mappedAsList[j].first)
            if (map[expected2] != null && coveredMods.firstOrNull{it.eq(ex2ModTrip)} == null) {
                coveredMods.add(ex2ModTrip)
                map[expected2]?.remove(a)
                map[expected2]?.remove(b)
                map[expected2]?.forEach { c ->
                    val trip = ITriple(a, b, c)
                    /*results.firstOrNull{it.eq(trip)} ?: */results.add(trip)
                }
                map[expected2]?.add(a)
                map[expected2]?.add(b)
            }
        }
    }

 */