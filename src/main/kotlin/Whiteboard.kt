import java.math.BigInteger
import java.util.*

const val name = "people"
class SomeClass {
    var mutableInt: Int = 4
    val immutableInt: Int = 5


    fun test() {
        for (i in 4 downTo 0 step -2) {

        }
    }
}

val a: Unit = Unit

fun newList(): List<String> = LinkedList()

fun addAll(vararg vals: String, separator: String) {
    vals.size
    vals[9]
    //addAll2(vals)
}

fun other() {
    addAll("", "", "", "", separator = "_")
}

fun <T : Number> addTwo(a: T, b: T): Double {
    return a.toDouble() + b.toDouble()
}

fun addAll2(vals: Array<String>) {

}


fun <T> genericTest(lambda: ()->T?) :List<T?> {
    LinkedList<T?>().add(lambda())
    return emptyList()
}

fun doferfff112() {
    val result = genericTest<String?> { "" }
}



fun addOne(a: Int) = a + 1
val addOneFunc = ::addOne
val addOneFunc2: (Int)->Int = ::addOne

class ClassS {
    fun getName() = "ClassS"
}

fun testadd() {
    addOneFunc(4)
    val classS = ClassS()
    val funcRef = classS::getName
}
fun add(a: BigInteger = BigInteger("0"), b: BigInteger = BigInteger("4")) = a.add(b)

object thing {
    fun a() = ""
    //const val thing: String? = null
}




inline fun <reified T: Number> printDecimals(v: Any) {
    if (v is T) {
        // ...
    }
}

fun `343 function name` (): String {
    return "hey"
}

val s = `343 function name`()


fun <T> takeMyObject(obj: T) where
        T : Comparable<T>,
        T : CharSequence {

}


fun printAllEntiresLongerThan(strings: List<String>, length: Int ) {
    fun printIfLongerThan(string: String, length: Int) {
        if(string.length > length) println(string)
    }
    strings.forEach { printIfLongerThan(it, length) }
}



val myFunc = fun (a:Int): Int = a + 1






