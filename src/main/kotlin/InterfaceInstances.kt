package interfacelisetners


import Interfaceinstances.Widget

fun main () {
    val myListener = {w: Widget -> println(w)}

    val w = Widget()

    println(w.listeners.size)

    w.addListener(myListener)

    println(w.listeners.size)

    w.removeListener(myListener)

    println(w.listeners.size)
}