package aliendict

import kotlin.random.Random

fun main() {
    val alphabet = generateAlienAlphabet(321, 7)
    val dictionary = generateAlienDictionary(alphabet, 321, 13)
    println(alphabet)
    println(dictionary)
}

fun generateAlienDictionary(alphabet: List<Char>, numberOfWords: Int = -1, seed: Long? = null): List<String> {
    val wordList = mutableListOf<String>()
    val rand = if (seed != null) Random(seed) else Random.Default
    val numWords = if (numberOfWords > 0) numberOfWords else 3 + rand.nextInt(16)
    (0..numWords).forEach {
        val length = 2 + rand.nextInt(8)
        val word = (0..length)
                .map { alphabet.random(rand) }
                .joinToString("")
        wordList.add(word)
    }
    wordList.sortWith(Comparator { o1, o2 ->
        var comp = 0
        for (i in 0..o1.length) {
            if (i >= o1.length && i < o2.length) {
                comp = if (comp != 0) comp else -1
                break
            }
            if (i >= o2.length && i < o1.length) {
                comp = if (comp != 0) comp else 1
                break
            }

            if (alphabet.indexOf(o1[i]) < alphabet.indexOf(o2[i])) {
                comp = -1
                break
            } else if (alphabet.indexOf(o1[i]) > alphabet.indexOf(o2[i])) {
                comp = 1
                break
            }
        }
        return@Comparator comp
    })
    return wordList
}

fun generateAlienAlphabet(numberOfLetters: Int? = null, seed: Long? = null): List<Char> {
    val rand = if (seed != null) Random(seed) else Random.Default
    val numLetters = if (numberOfLetters != null && numberOfLetters in 1..26) numberOfLetters else 4 + rand.nextInt(16)
    return ('a'..'z').toList().shuffled(rand).subList(0, numLetters)
}