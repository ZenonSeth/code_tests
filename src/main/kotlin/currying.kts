import java.util.*


typealias Fun2<A, B, C> = (A, B) -> C

typealias Chain<A, B, C> = (A) -> (B) -> C

fun <A, B, C> Fun2<A, B, C>.curry(): (A) -> (B) -> C = { a: A ->
    { b: B ->
        this(a, b)
    }
}
fun <A, B, C> Chain<A, B, C>.flip(): Chain<B, A, C> = { b: B ->
    { a: A ->
        this(a)(b)
    }
}



val sum = { a: Int, b: Int -> a + b }
val sumC = sum.curry().flip()

fun decode(str: String, locale: Locale) {}


fun main() {
    val ukLocale = ::decode.curry().flip()(Locale.UK)

    val ukDecode = ::decode.let { { str: String -> decode(str, Locale.UK) } }

    ukLocale("Hello")
}