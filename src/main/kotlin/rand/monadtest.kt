package rand

/**
 * Written by Milcho on 12/13/2018.
 */


fun main() {
    val charToListOfInt: (Char) -> List<Int> = {it -> listOf(it.minus('a'))}
    val charlist = listOf('a', 'b', 'z')
    val res = charlist.flatMap { charToListOfInt(it) }

}


