import java.util.*


/*
    Basic assignment via between Var/Val and Const
 */


// String someString = "text";

var varString: String = "text"

val valString: String = "another"

object testObj {

    const val constString1 = ""
    //const val constString2 = varString
    //const val constString3 = valString

//    var nonStr: String?

}

varString = valString



// String someString = "text";
// someString = null;

//var nullableString: String? = null
//val nullableString: String? = null


var nullableString = ""


var a: Int? = 4
var b: Int = 5

a = b
// b = a // does not compile

val one = 2
val two = 1

val sum: List<Int> = listOf(4,3,1)


val byte1: Byte = 1
val byte2: Byte = 2
val byte3 = byte1 + byte2

val charA = '0'
val charB = '1'
val charF = charA + 1   // charF is of type char
val charG = charB - 1   // charG is of type char
val charH = charA - '1' // charH is of type char
//val charI = charA + charB   // doesn't eevn compile
val charJ = charA - charB   // charJ is of type Int

object ConstTest {
    val s = "text"
    //const val s2 = s
    //const val s3 = getString()
    fun getString() = ""
}

