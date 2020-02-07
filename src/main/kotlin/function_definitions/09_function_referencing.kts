package function_definitions

import kotlin.math.abs


fun addOne(a: Int) = a + 1





val addOneFunc: (Int)->Int = ::addOne









class Cla55 {
    fun getName() = "ClassS"
}







val classS = Cla55()
val funcRef: ()->String = classS::getName

val str: String = funcRef()













val myFunc = fun (a:Int): Int = a + 1










