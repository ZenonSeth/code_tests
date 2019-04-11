
enum class myenum {
    ONE, TWO
}

fun main() {
//    do_one()
//    do_two()

    val sc1: myseal = myseal.TWO(1, 0)
    val sc2: myseal = myseal.TWO(2, 0)

//    when(sc1) {
//        is myseal.ONE -> print("one")
//        is myseal.TWO -> print()
//    }

    val so1: myseal = myseal.ONE
    val so2: myseal = myseal.ONE

    so1.myInt = 6

    when {

    }

}


sealed class myseal(var myInt: Int) {

    object ONE : myseal(0)

    class TWO(myInt: Int, val int2: Int) : myseal(myInt)
}




enum class two {
    one, two, three, foud
}

