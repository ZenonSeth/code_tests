data class SFClass(var i: Int)

fun main() {
    var a: SFClass? = SFClass(0)

    val runRet: String =
            run { // a is not passed in specifically, is just variable that can be null
                if (a != null) a.i.toString() else "a was null"
            }

    val withRet: String =
            with(a) {
                if (this != null) i.toString() else "a was null"
            }

    val aDotRun: String =
            a?.run {
                i.toString()
            } ?: "a was null"

    val aDotLet: String =
            a?.let {
                a.i.toString()
            } ?: "a was null"

    val aDotApply: SFClass? =
            a.apply {
                this?.i = 4
            }

    val aDotApplySafe: SFClass? =
            a?.apply {
                i = 4
            }

    val aDotAlso: SFClass? =
            a.also {
                it?.i = 4
            }

    val aDotAlsoSafe: SFClass? =
            a?.also {
                it.i = 4
            }
}