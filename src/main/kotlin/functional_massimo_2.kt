package functional.massimo.two

import java.lang.Thread.sleep
import java.util.*

typealias Fun<A, B> = (A) -> B

// Normal function
fun double(value: Int): Int = value * 2

fun square(value: Int): Int = value * value

fun <A> dump(value: A): Unit = println(value)

// Why function(pure) is like data
// Example of function with a function in input -> duration
fun duration(fn: () -> Unit): Long {
    val start = System.nanoTime();
    fn()
    return System.nanoTime() - start
}

// Example of function which creates a function -> multiplier
fun multi(factor: Int): Fun<Int, Int> = { input: Int -> factor * input }

// Example of function in input and output: composition
infix fun <A, B, C> Fun<A, B>.compose(fn: Fun<B, C>): Fun<A, C> = { a: A ->
    fn(this(a))
}

infix fun <A, B> A.push(fn: (A) -> B) = fn(this)

// Currying
fun translate(str: String, locale: Locale) = "{ translated : $str}"

typealias Fun2<A, B, C> = (A, B) -> C
typealias Currying<A, B, C> = Fun<A, Fun<B, C>>

fun <A, B, C> Fun2<A, B, C>.currying(): Currying<A, B, C> = { a: A ->
    { b: B -> this(a, b) }
}

fun <A, B, C> Currying<A, B, C>.inv(): Currying<B, A, C> = { b: B ->
    { a: A ->
        this(a)(b)
    }
}


fun main() {
    val delay = duration {
        sleep(200)
    }
    println(delay)
    val fm = multi(3)
    println(fm(30))
    println(fm(37))


    val curTransl = Locale.UK push ::translate.currying().inv()

    val fc = ::square compose ::double compose Int::toString compose curTransl compose ::dump
    17 push fc
}