package kotlin_oddities


// also calling non-null vals from constructor

abstract class A {
    init { println("Initializing ${getName()}") }
    abstract fun getName(): String
}

class B : A() {
    val className: String
            get() = "B Class"
    override fun getName() = className
}


fun main() {

    B()

//    println(null + null)
//
//    println('1'.toInt() + 12323.3)
//
//    println('1'.toDouble())
//
//    println('0' + 1)
//
//    println('0' - 1)
//
//    println("asdf" + 200.toChar() + 201.toChar() + 97.toChar() + "M")

}

