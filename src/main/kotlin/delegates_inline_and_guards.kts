import kotlin.reflect.KFunction1

class ClassOne {
    fun apiCallTwo(param: String) {
        println("api call two $param")
    }

    fun apiCallOne(param: String) {
        println("api call one $param")
    }

    operator fun invoke() {

    }
}


class ClassOneWrapper {

    var wrapped: ClassOne? = null

    constructor (wrapped: ClassOne) {
        this.wrapped = wrapped
    }

    constructor() : this(ClassOne()) {

    }

    lateinit var apiCallTwo: KFunction1<@ParameterName(name = "param") String, Unit>

    init {

    }

    fun myInit() {
        //apiCallTwo = wrapped::apiCallTwo
    }

    fun apiCallOne(number: Int) {
        //wrapped.apiCallOne("param=$number")
    }

}


val wrapper = ClassOneWrapper(ClassOne())

wrapper.apiCallOne(4)

val func1 = wrapper::apiCallOne
val func = wrapper.apiCallTwo

val func2 = wrapper::apiCallTwo

wrapper.myInit()


val a = 0
val b = 0
val c = 1

fun boolthing(a: Boolean, b: Boolean) {

}

val MIN = 0
val MAX = 1000

if (MIN <= a && a <= MAX)

    boolthing(a < b, c < b)


val UNDEFINED: Any? = null

//val aStr: String? = UNDEFINED


fun anyNull(vararg arr: Any?): Boolean = arr.any {
    it == null
}

fun anyNull2(vararg arr: Any?): Any? = if (arr.any { it == null }) null else Unit


inline infix fun Boolean.guard(block: () -> Unit) = if (this) block() else Unit

inline fun guard2(f: () -> Boolean): Any {
    if (f()) return 1 else return 0
}


////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////

fun doStuff(a: Int?, b: String?) {

    a ?: return
    b ?: return


    println("${a.toBigDecimal()} + ${b.length}")
}

doStuff(1, "")
doStuff(null, "")













