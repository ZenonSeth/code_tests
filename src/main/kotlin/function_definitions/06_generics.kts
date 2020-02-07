package function_definitions






fun <T : Number> aGenericFunc(other: T) {

}




















fun <T : Number> addTwo(a: T, b: T): Double =
    a.toDouble() + b.toDouble()




















fun <T> takeMyObject(obj: T) where
        T : Comparable<T>,
        T : CharSequence {


    obj.compareTo(obj)
    obj[4]

}
