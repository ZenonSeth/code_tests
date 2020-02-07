package kotlin_oddities



abstract class ATT (func: ATT.() -> Unit) {

    private fun <T : ATT> exec(func: T.()->Unit): ATT.()->Unit {
        return { (this as T).func() }
    }
}

class BTT(func: BTT.() -> Unit) {
    init { func() }
}

val doubleFunc = fun Double.() {

}

fun numFunc(numFunc: Number.() -> Unit) {

}

//numFunc(doubleFunc)



abstract class BaseClass {
    val otherInfo = "something"
    init {

        println("--parent init called")
        initBackground()
    }

    private fun initBackground() {
        println(otherInfo)
        printDebugInfo()
    }

    open fun printDebugInfo() = Unit
}


class AClass : BaseClass() {

    var aNum = 0
    val debugInfo = "A Class debug info"

    init{

        println("--child called")
        println("A num = $aNum")
    }

    override fun printDebugInfo() {
        println("-- printDebugInfo called")
        println(debugInfo)
        aNum = 15
    }
}


println("---- Class non-nulls being null\n")

AClass()

println("---- Listeners don't get removed\n")

val myListner = { println("click") }

val view = MyView()

view.addOnClickListener(myListner)

view.simulateOnClick()

view.removeClickListener(myListner)

view.simulateOnClick()
view.simulateOnClick()
view.simulateOnClick()
view.simulateOnClick()
view.simulateOnClick()







