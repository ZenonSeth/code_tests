
fun main() {
    main_2()
}



data class StringData(var str: String)

data class CompositeData(val data: StringData, var i: Int?)




fun main_1() {
    val dt1 = StringData("one")
    modifyData(dt1.copy())
    println(dt1)
}

fun modifyData(dt: StringData) {
    dt.str = "two"
    println(dt)
}

fun test23(condition: Boolean) {
    val a: Int = if (condition) getint() else printExc()
}

fun getint(): Int {
    return 5
}

fun printExc(): Nothing {
    throw Exception()
}



public class Nothing2 private constructor()


fun main_2(){
    val dt1 = CompositeData(StringData("one"), 1)
    modifyCompositeData(dt1.copy(i = 3))
    println(dt1)

}

fun modifyCompositeData(cdt: CompositeData) {
    cdt.data.str = "two"
    cdt.i = 2
    println(cdt)
}



sealed class MyLinkedList<out T>  {

    data class Node<T>(val payload: T, var next: MyLinkedList<T> = EmptyList) : MyLinkedList<T>()

    object EmptyList : MyLinkedList<Nothing>()

}
