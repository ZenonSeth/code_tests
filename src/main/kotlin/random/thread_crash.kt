package random

import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val jobs = List(1_000_000) {
        thread {
            Thread.sleep(1000L)
            println("Thread $it")
        }
    }
    jobs.forEach { it.join() }
    println("END!")
}