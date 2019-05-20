package test.mipe


object FRAC {
    fun a() {
        inlinedFunc { 3 }
    }

    fun b() {
        nestedInline({1},{2})
    }

    inline fun nestedInline(a: () -> Int, b: () -> Int): Int {
        return inlinedFunc { a() + b() }
    }

    inline fun inlinedFunc(a: () -> Int): Int {
        // if you uncomment these lines, it causes compilation error (also interesting to see the bytecode/decompiled Java it generates)
//        if (nestedInline({4},{3}) == 0) {
//            return 1
//        }
        (0..a()).forEach { println(it) }
        return 0
    }
}