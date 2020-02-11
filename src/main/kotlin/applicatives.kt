sealed class Maybe<out A> {
    fun <B> map(fn: (A) -> B): Maybe<B> = when (this) {
        is Some<A> -> Some(fn(this.value))
        else -> None
    }
}

class Some<A>(val value: A) : Maybe<A>()

object None : Maybe<Nothing>()

// Let's make it an applicative
inline fun <reified A> just(value: A): Maybe<A> = Some(value)

fun <A, B> Maybe<A>.ap(fn: Maybe<(A) -> B>): Maybe<B> =
    if (this is None || fn is None)
        None
    else
        Some((fn as Some<(A) -> B>).value((this as Some<A>).value))


data class User(val id: Int, val name: String, val email: String)

val userBuilder = { id: Int -> { name: String -> { email: String -> User(id, name, email) } } }


infix fun <A,B> Maybe<(A) -> B>.app(a: Maybe<A>) = flip<Maybe<(A) -> B>, Maybe<B>, Maybe<A> >(Maybe<A>::ap)(a)


infix fun <A,B> Maybe<(A) -> B>.app2(a: Maybe<A>) = a.ap(this)





fun <THIS, RESULT, T> flip (fn: T.(THIS) -> RESULT): THIS.(a: T) -> RESULT =
    { f: T -> f.fn(this) }




fun String.myFirst(num: Int) = substring(0, num)

infix fun Int.firstOfStr(s: String) = flip(String::myFirst)(s)
infix fun Int.firstOfStr2(s: String) = s.myFirst(this)



fun main() {

    "some strhing".myFirst(5)


    val firstFour: String.() -> String = { substring(0, 4) }

    val subStr: String = "input string".firstFour()



    val idVal = just(1)
    val nameVal = just("Max")
    val emailVal = just("massimoc@spotify.com")
    val userApp = just(userBuilder)
    // In this case the Maybe is a Some and the user is printed


    emailVal.ap(nameVal.ap(idVal.ap(userApp))).map { println(it) }


    val res: Maybe<User> = userApp app2 idVal app2 nameVal app2 emailVal


    // In this case is a None because the name is missing and nothing is printed
    val missingName = None
    emailVal.ap(missingName.ap(idVal.ap(userApp))).map { println(it) }
}
