

interface Source<out T> {
    fun next() : T
}

fun function_1(
        aDouble: Double,
        doubleSource: Source<Double>
) {
    val aNumber: Number = aDouble

    val otherNumber: Number = doubleSource.next()

    val numberSource : Source<Number> = doubleSource

}

interface Bin<in T> {
    fun chuck(other: T)
    //fun doforeach( v: (T)->Unit)
}

fun function_2(
        aNumber: Number,
        numberBin: Bin<Number>
) {

    //val x : Double = aNumber

    val input: Double = 2.0
    numberBin.chuck(input)   // note that 'input' is a double

    val doubleBin: Bin<Int> = numberBin
}

////////////////////////////////////////////////////////////////

interface MyList<T> {
    fun get(index: Int) : T
    fun add(value: T)
}

fun doThings(stringList: MyList<String>, numberList: MyList<Number>) {

    stringList.add("string")

    val someString: String = stringList.get(0)

    //val anyList: MyList<Any> = stringList
    val anyList2: MyList<out Any> = stringList

    //val doubleList: MyList<Double> = numberList
    val doubleList2: MyList<in Double> = numberList
}



fun test2(vararg v: String) {
    //test3(v)
    test3(arrayOf(*v))
}

fun test3(v: Array<String>) {}


