package com.first

import java.text.DateFormat
import java.util.*


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

private var globalLocale = Locale.UK

fun main() {
    runConvertUnixTimestampProg()
}

fun runConvertUnixTimestampProg() {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Current globalLocale is ${globalLocale.displayName}")
        println("Enter Linux Timestamp to convert, L to change Locale or X to exit")
        val input = scanner.nextLine()
        when {
            input.startsWith("x", true) -> return
            input.startsWith("l", true) -> readAndUpdateLocale(scanner)
            input.toLongOrNull() != null -> printDate(input.toLong())
            else -> println("Invalid option selected!")
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun printDate(timestamp: Long) {
    val timeInstance = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, globalLocale)
    println("> ${timeInstance.format(Date(timestamp))}\n")
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun readAndUpdateLocale(scanner: Scanner) {
    println("Current globalLocale is ${globalLocale.displayName}")
    println("Select from:\n 1. UK\n 2. US")
    when (scanner.nextLine().toIntOrNull()) {
        1 -> globalLocale = Locale.UK
        2 -> globalLocale = Locale.US
        else -> println("Invalid locale option entered!")
    }
}
