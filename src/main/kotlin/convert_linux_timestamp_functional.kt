package com.second

import java.io.PrintStream
import java.text.DateFormat
import java.util.*


fun main() {
    Locale.UK.runConvertTimestampProg(Scanner(System.`in`), System.out)
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

tailrec fun Locale.runConvertTimestampProg(scanner: Scanner, out: PrintStream) {
    getUserChoice(scanner, out, this).let { input ->
        when {
            input.startsWith("x", true) -> return
            input.startsWith("l", true) -> readNewLocale(this, scanner, out)
            else -> input.printDate(out, this).let { this }
        }
    }.runConvertTimestampProg(scanner, out)
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun getUserChoice(scanner: Scanner, out: PrintStream, locale: Locale): String {
    out.println("Current globalLocale is ${locale.displayName}")
    out.println("Enter Linux Timestamp to convert, L to change Locale or X to exit")
    return scanner.nextLine().trim()
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun readNewLocale(locale: Locale, scanner: Scanner, out: PrintStream): Locale {
    out.println("Current globalLocale is ${locale.displayName}")
    out.println("Select from:\n 1. UK\n 2. US")
    return when (scanner.nextLine().toIntOrNull()) {
        1 -> Locale.UK
        2 -> Locale.US
        else -> println("Invalid locale option entered!").let { locale }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun String.printDate(out: PrintStream, locale: Locale) {
    toLongOrNull()?.let { timestamp ->
        DateFormat
            .getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, locale)
            .run { out.println("> ${format(Date(timestamp))}\n") }
    } ?: out.println("Invalid timestamp!")
}
