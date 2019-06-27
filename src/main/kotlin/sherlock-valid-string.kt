import java.util.*

// Complete the isValid function below.
fun isValidSherlockString(s: String): String {
    if(s.isEmpty()) return "YES"

    val charMap = mutableMapOf<Char, Int>()
    s.forEach { ch -> charMap[ch] = (charMap[ch]?.plus(1) ?: 1) }

    val counts = mutableMapOf<Int, Int>()
    charMap.forEach{_, count ->
        counts[count] = counts[count]?.plus(1) ?: 1
    }
    return when {
        counts.size == 1 -> "YES"
        counts.size > 2 -> "NO"
        else -> {
            val last = counts.entries.last()
            val first = counts.entries.first()
            if ((first.value == 1 && (first.key == last.key + 1 || first.key == 1))
                || (last.value == 1 && (last.key == first.key + 1 || last.key == 1)))
                "YES"
            else "NO"
        }
    }
}

fun main(args: Array<String>) {
    var s: String
    do {
        val scan = Scanner(System.`in`)

        s = scan.nextLine()

        val result = isValidSherlockString(s)

        println(result)
    } while (!s.isEmpty())
}
