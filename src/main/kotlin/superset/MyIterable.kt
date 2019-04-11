package superset

class MyIterable {

    operator fun iterator(): Iterator<Int> {
        return ArrayList<Int>().iterator()
    }

}

 inline fun MyIterable.forEach(action: (Int) -> Unit) {
    for (element in this) action(element)
}