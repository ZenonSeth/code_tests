import Interfaceinstances.Widget


fun main () {

    val myListener = { w: Widget -> println("Listener Called!")}

    val w = Widget()


    println("\nbefore adding any")
    println(w.listeners.size)

    w.addListener(myListener)

    println("\nafter adding one")
    println(w.listeners.size)

    w.removeListener(myListener)

    println("\nafter removing")
    println(w.listeners.size)
}