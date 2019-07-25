//
//
//fun kotlin_oddities.main () {
//    val myfact = myfact()
//    myfact.t = 4
//    println("--${myfact.t}")
//
//    val myfibb = myfibb()
//    myfibb.t = 3
//    println("fib: ${myfibb.t}")
//}
//
//
//class myfact {
//    var t: Int = 0
//        set(value) {
//            if (value == 1) {
//                field = value
//            } else {
//                t = value - 1
//                field = value * t
//                println(field)
//            }
//        }
//}
//
//
//class myfibb {
//    var t: Int = 0
//        set(value) {
//            if (value == 1 || value == 0)  {
//                field = 1
//            } else {
//                t = value - 1
//                val a = t
//                t = value - 1
//                field = a + t
//            }
//        }
//}


fun main() {
    (0..5).forEach { i ->
        val d = Data()

    }
}

class Data {

}


fun curryVal2(i: Int, func: (Int, Data) -> Unit): (Data) -> Unit {
    return { d1: Data -> func(i, d1) }
}


fun getVal2(): (Int, Data) -> Unit {
    return { i: Int, d: Data -> }
}


fun curryValidatorWith(i: Int, func: (Int, String, String) -> Unit): (String, String) -> Unit {
    return { s1: String, s2: String -> func(i, s1, s2) }
}


fun getValidationFunc(): (Int, String, String) -> Unit {
    return { i: Int, s1: String, s2: String -> }
}




