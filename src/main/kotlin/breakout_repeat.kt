class Brakable(private val b: () -> Nothing) {
    val breakout: Nothing
        get() = b()
}

fun mrepeat(times: Int, action: Brakable.(Int) -> Unit) {
    class __BE : Throwable()
    val breaker = Brakable { throw __BE() }
    try {
        for (index in 0 until times) {
            breaker.action(index)
        }
    } catch (ignored: __BE) {
        return
    }
}


fun repeat_test() {
    mrepeat(5) {
        println(it)
        if (it == 1) breakout
        println("after breakout")
    }
}

fun main() {
    repeat_test()
}




