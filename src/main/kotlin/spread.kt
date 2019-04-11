

open class str () {
    var len = 0
}

class strsub : str() {

}


fun main() {
    val s1 = str()
    doA(s1, strsub())
    println(s1.len)


    doB(arrayOf(str(), strsub()))
}


fun doA(vararg v: str) {
    v[0].len = 3
}

fun doB(v: Array<in str>) {
//    v[1] = str()
    v[0] = str()
}