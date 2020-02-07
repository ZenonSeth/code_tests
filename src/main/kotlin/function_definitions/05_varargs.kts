package function_definitions




fun areAllSame(vararg strings: String): Boolean {
    if (strings.size == 0) {
        val firstString  = strings[0]
    }
    areAllSame2(strings)
    return true
}

fun areAllSame2(string: Array<out String>) {

}

areAllSame(", ", "4")



















fun myConcat(howMany: Int,
             vararg strings: String,
             separator: String = "_"): String {
    TODO()
}

myConcat(4, "1", "2")




















