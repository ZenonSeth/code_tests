package puzzlers

/***
 *
 *    Credit for puzzlers goes to Anton Keks, KotlinConf 2017
 *
 *
 *
 */


/****************************************************************
 *  01
 ****************************************************************/

//val x: String? = "foo"
//
//print(x == "foo" ? "is foo" : "not a foo")

/**
 * What will it print?
 *  a) "is foo"
 *  b) "not a foo"
 *  c) won't compile
 *  d) none of the above
 */



















/****************************************************************
 *  02
 ****************************************************************/

//fun hello(): String {
//    val result = return throw return "Hello"
//    println(result.toString())
//}
//
//println(hello())

/**
 * What will it print?
 * a) Hello
 * b) Hello Hello
 * c) does not compile
 * d) none of the above
 */













/****************************************************************
 *  03
 ****************************************************************/

//fun numbers(list: List<Int>) {
//    list.forEach {
//        if (it > 2) return
//        print(it)
//    }
//    print("ok")
//}
//
//numbers(listOf(1,2,3))

/**
 * What will it print?
 * a) 123ok
 * b) 12ok
 * c) 12
 * d) Infinite Loop
 */

























/****************************************************************
 *  04
 ****************************************************************/

//val x: Any = "123"
//val z = if (x is String && x is Int) x.inc() + x.length else 123
//println(z)

/**
 * What will it print?
 * a) 123
 * b) 127
 * c) ClassCastException
 * d) will not compile
 */

















/****************************************************************
 *  05
 ****************************************************************/

//class Order {
//    private val c: String
//    init {
//        the()
//        c = ""
//    }
//    private fun the() {
//        println(c.length)
//    }
//}
//
//Order()

/**
 * What will it print?
 * a) 0
 * b) null
 * c) will not compile
 * d) none of the above
 */




















/****************************************************************
 *  06
 ****************************************************************/

//open class Node(val name: String) {
//    fun lookup() = println(name)
//}
//
//class Parent : Node("parent") {
//    fun child(name: String) : Node? = Node(name)
//
//    val child1 = child("child1")?.apply { lookup() }
//    val child2 = child("child2").apply { lookup() }
//}
//
//Parent()


/**
 * What will it print?
 * a) child1; child2
 * b) won't compile
 * c) NullPointerException
 * d) none of the above
 * d) none of the above
 */
























/****************************************************************
 *  07
 ****************************************************************/

//typealias L = (String) -> Unit
//
//fun foo(one: L = {}, two: L = {}) {
//    one("one")
//    two("two")
//}
//
//foo {print(it)}
//foo({print(it)})

/**
 * What will it print?
 * a) oneone
 * b) twotwo
 * c) onetwo
 * d) none of the above
 */































/****************************************************************
 *  08
 ****************************************************************/

//open class Named {
//    open var name: String? = null
//        get() = field ?: "<unnamed>"
//}
//
//class Person: Named() {
//    override var name: String? = null
//        get() = super.name
//        set(value) { field = "Mr $value"}
//}
//
//val person = Person()
//person.name = "Anton"
//println(person.name)

/**
 * What will it print?
 * a) Anton
 * b) Mr Anton
 * c) <unnamed>
 * d) null
 */




















/****************************************************************
 *  09
 ****************************************************************/

//infix operator fun Int.plus(i: Int) = this + i + 1
//
//println(-1 + 2)
//println(-1 plus 2)
//println(-1.plus(2))

/**
 * What will it print?
 * a) 1 1 1
 * b) 2 2 2
 * c) 1 2 -3
 * d) 2 -4 -4
 */



















/****************************************************************
 *  10
 ****************************************************************/
//
//class Population(var cities: Map<String, Int>) {
//    val `san francisco` by cities
//    val `london` by cities
//    val `kotlin` by cities
//}
//
//val population = Population(mapOf(
//    "san francisco" to 864_816,
//    "london" to 8_136_212,
//    "kotlin" to 43_005))
//
//// after global warming makes us extinct
//population.cities = emptyMap()
//
//with (population) {
//    println("$`san francisco` ; $london ; $kotlin")
//}

/**
 * What will it print?
 * a) 0 ; 0 ; 0
 * b) 864816 ; 8136212 ; 43005
 * c) NullPointerException
 * d) NoSuchElementException
 */
























/****************************************************************
 *  11
 ****************************************************************/

//operator fun Nothing?.not() = Unit
//operator fun Unit.not() = null
//
//val foo = null
//
//println(!!!!!foo!!!!)

/**
 * What will it print?
 * a) null
 * b) Kotlin.Unit
 * c) KotlinNullPointerException
 * d) will not compile
 */





































/****************************************************************
 *  12
 ****************************************************************/

//fun printNumberSign(num: Int) {
//    if (num < 0) {
//        "negative"
//    } else if (num > 0) {
//        "positive"
//    } else {
//        "zero"
//    }.let { println(it) }
//}
//
//printNumberSign(-2)
//printNumberSign(0)
//printNumberSign(2)

/**
 * What will it print?
 * a) negative; zero; positive
 * b) negative; zero
 * c) negative; positive
 * d) zero; positive
 */





























/****************************************************************
 *  13
 ****************************************************************/

//val i = 10.5
//
//when (i) {
//    in 1..10 -> println("in")
//    !in 1..10 -> println("!in")
//    else -> println("else")
//}

/**
 * What will it print?
 * a) in
 * b) !in
 * c) else
 * d) will not compile
 */

























/****************************************************************
 *  14
 ****************************************************************/

//operator fun String.invoke(a: () -> String) = this + a()
//
//fun String.z() = "!$this"
//fun String.toString() = "$this!"
//
//println("x"{"y"}.z())

/**
 * What will it print?
 * a) !x
 * b) !xy
 * c) !xy!
 * d) will not compile
 */
































/****************************************************************
 *  15
 ****************************************************************/

//open class C {
//    open fun sum(x: Int = 1, y: Int = 2) = x + y
//}
//
//class D : C() {
//    override fun sum(y: Int, x: Int): Int = super.sum(x, y)
//}
//
//val d: D = D()
//val c: C = d
//
//print(c.sum(x = 0))
//print(d.sum(x = 0))
//println()

/**
 * What will it print?
 * a) 22
 * b) 11
 * c) 21
 * d) will not compile
 */


