package store

interface Store<K, T : Entry<K>> {

    fun filter(matcher: (T)->Boolean): Store<K, T>

    fun request(requestKey: K)

}
