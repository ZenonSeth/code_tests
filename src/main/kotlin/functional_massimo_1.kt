package functional.massimo.one

import java.lang.Error

sealed class Result<out E, out A>

class Success<A>(val a: A) : Result<Nothing, A>()

class Failure<E>(val error: E) : Result<E, Nothing>()

// Functor
fun <A, B, E> Result<E, A>.map(f: (A) -> B): Result<E, B> = when (this) {
    is Success<A> -> Success(f(this.a))
    is Failure<E> -> this
}

// Monad
fun <A, B, E> Result<E, A>.flatMap(f: (A) -> Result<E, B>): Result<E, B> = when (this) {
    is Success<A> -> f(this.a)
    is Failure<E> -> Failure(this.error)
}

// Applicative
fun <A> pure(value: A) = Success(value)

fun <A, B, E> Result<E, A>.ap(f: Result<E, (A) -> B>): Result<E, B> = when {
    this is Success<A> && f is Success<(A) -> B> -> Success((f.a)(this.a))
    else -> when {
        this is Failure -> this
        else -> Failure((f as Failure<E>).error)
    }
}

infix fun <A, B, E> Result<E, (A) -> B>.appl(value: Result<E, A>): Result<E, B> = value.ap(this)
data class User(val id: Int, val name: String, val email: String)

val userBuilder = { id: Int -> { name: String -> { email: String -> User(id, name, email) } } }

fun main_a() {
    val idApp = pure(10)
    val nameApp = pure("Max")
    val missingNameApp = Failure("Error")
    val emailApp = pure("max@spot.com")
    val builderApp = pure(userBuilder)
    emailApp.ap(missingNameApp.ap(idApp.ap(builderApp))).map {
        print(it)
    }
    (builderApp appl idApp appl nameApp appl emailApp).map {
        print(it)
    }
}

