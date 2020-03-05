// KTS

enum class Triple { R, G, B }

/*

    Boolean => {true, false}
    Triple => {r, g, b}

    Boolean + Triple = {true, false, r, g, b}
    Boolean * Triple = { {true, r}, {true, g}, {true, b}, {false, r}, {false, g}, {false, b} }

    Boolean * Boolean * Triple =
        { {tt} {tf} {ft} {ff} } * {rgb} =
        { {rtt} {rtf} {rft} {rff} ... {bff} }

    in general:

    X1 * X2 * .. * XN = {m1, m2 .. mN} where mi is a member of Xi for every i = [1..N]

    // what about Boolean + Boolean?
    Boolean + Boolean = {true, false.... ?}

    // Boolean * Boolean is easier
    Boolean * Boolean = { {t,t}, {t,f}, {f,t}, {f,f} }


    Boolean ^ Triple =  .. why Boolean * Boolean * Boolean ?
    this is just Boolean ^ cardinalityOf{Triple}

    So in category theory {the mathematical one} a product also includes a set of mappings
    However, nowhere is there an idea of "raising" one category to the other

    // misc

    Boolean ^ Nothing = Unit  // maybe but why? 3^0 = 1 but that's irrelevant to this discussion

    {true, false} ^ 2 = {true, true}, {true, false}, {false, true}, {true, false}
    //aka its just Boolean * Boolean

    {true, false} ^ 0 = {}

    {true, false} ^ {true, false} = ??
    {true, false} ^ {} = ??


    AFAIK this has no real category theory behind it and is just made up


 */


//    Boolean + Triple = (true, false, r, g, b)
sealed class Union<A, B> {
    class A<A, B>(val value: A) : Union<A, B>()
    class B<A, B>(val value: B) : Union<A, B>()
}

val aBool1 = true
val aTriple1 = Triple.R

val boolUnionTriple: Union<Boolean, Triple> = if (aBool1) Union.A(aBool1) else Union.B(aTriple1)

when (boolUnionTriple) {
    is Union.A -> {
        { b: Boolean -> println(b) }.invoke(boolUnionTriple.value)
    }
    is Union.B -> {
        { t: Triple -> println(t) }.invoke(boolUnionTriple.value)
    }
}


// Boolean * Triple = ( (true, r), (true, g), (true, b), (false, r), (false, g), (false, b) )

class Prod<A, B>(val a: A, val b: B)

val a_member_of_cartesian_prod_of_bool_and_triple = Prod(false, Triple.B)

println("${a_member_of_cartesian_prod_of_bool_and_triple.a} ${a_member_of_cartesian_prod_of_bool_and_triple.b}")


/*
    (A,B,C) ^ (X,Y) -> ( (A,A), (A,B), (A,C), ... (C,C) )
    lets call ^ 'translate'
 */


data class NTuple<A>(val values: List<A>, val N: Int = values.size)

fun <A, B> translate(power: Set<B>, func: (B) -> A): NTuple<A> =
    NTuple<A>(power.fold(listOf<A>()) { acc, it -> acc.plus(func(it)) })

println(translate(setOf<Nothing>(), { _: Nothing -> false}))
