package com.second

import java.io.PrintStream
import java.text.DateFormat
import java.util.*

data class AppState(val locale: Locale)

fun main() {
    AppState(Locale.UK).runConvertTimestampProg(Scanner(System.`in`), System.out)
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

tailrec fun AppState.runConvertTimestampProg(scanner: Scanner, out: PrintStream) {
    getUserChoice(scanner, out, this).let { input ->
        when {
            input.startsWith("x", true) -> return
            input.startsWith("l", true) -> readNewLocale(this, scanner, out)
            else -> input.printDate(out, this)
        }
    }.runConvertTimestampProg(scanner, out)
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun getUserChoice(scanner: Scanner, out: PrintStream, appState: AppState): String {
    out.println("Current globalLocale is ${appState.locale.displayName}")
    out.println("Enter Linux Timestamp to convert, L to change Locale or X to exit")
    return scanner.nextLine().trim()
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun readNewLocale(appState: AppState, scanner: Scanner, out: PrintStream): AppState {
    out.println("Current globalLocale is ${appState.locale.displayName}")
    out.println("Select from:\n 1. UK\n 2. US")
    return when (scanner.nextLine().toIntOrNull()) {
        1 -> appState.copy(locale = Locale.UK)
        2 -> appState.copy(locale = Locale.US)
        else -> println("Invalid locale option entered!").let { appState }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fun String.printDate(out: PrintStream, appState: AppState): AppState {
    toLongOrNull()?.let { timestamp ->
        DateFormat
            .getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, appState.locale)
            .run { out.println("> ${format(Date(timestamp))}\n") }
    } ?: out.println("Invalid timestamp!")
    return appState
}
