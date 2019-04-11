package random

import io.reactivex.Completable

fun main() {

    val com = Completable.fromAction { println("Start"); }
    com
            .doAfterTerminate { println("Do After terminate ONE") }
            .doAfterTerminate { println("Do after terminate TWO") }
            .doOnComplete { println("Do on complete called UNO") }
            .doOnComplete { println("Do on complete called DOS") }
            .andThen(Completable.fromAction { println("switcheroo") })
            .subscribe { println("Subscribe's onComplete call") }
}

