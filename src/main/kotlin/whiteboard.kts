import io.reactivex.Single
import io.reactivex.subjects.CompletableSubject
import io.reactivex.subjects.SingleSubject
import java.lang.IllegalStateException
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean




//val a: Byte = 1
//val b: Byte = 2
////val c: Byte = a + b
//
//val cA: Char = '1'
//val cB = cA+ 1
//
//println(cB)
//println(cA)
//
//fun verify(i:Int){}
//fun verify(s:String){}
//
//
//
//
//
//typealias ID<T> = Either.Left<T>
//typealias TEXT<T> = Either.Right<T>
//
//fun testEither(stringOrId: Either<Int, String>) {
//    stringOrId.fold(
//        { ID -> verify(ID) },
//        { TEXT -> verify(TEXT) }
//    )
//}
//
//testEither(ID(3))
//testEither(TEXT("adsf"))

//
//fun testSubscribeOn() {
//
//    val sub = Observable.unsafeCreate<String> {
//        println("Got observer: $it on thread ${Thread.currentThread()})")
//    }
//
//
//    val s1 = Schedulers.single()
//    val s2 = Schedulers.single()
//    val io = Schedulers.io()
//
//    println(s1 == s2)
//
//    println("single subscribeOn, s1")
//    sub
//        .subscribeOn(s1)
//        .subscribe()
//
//
//    Thread.sleep(200)
//    println("single subscribeOn, s2")
//    sub
//        .subscribeOn(s2)
//        .subscribe()
//
//
//    Thread.sleep(200)
//    println("multiple subscribeOn, s1 then io")
//    sub
//        .subscribeOn(s1)
//        .subscribeOn(io)
//        .subscribe()
//
//    Thread.sleep(200)
//    println("multiple subscribeOn, io then s1")
//    sub
//        .subscribeOn(io)
//        .subscribeOn(s1)
//        .subscribe()
//
//    val login = Single.just("%")
//
//    Single.create<String>(
//        { emitter ->
//            login.subscri
//        }
//    )
//
//}
//
//testSubscribeOn()

//
//val executing: AtomicBoolean = AtomicBoolean(false)
//fun login(): Single<String> {
//    return if (!executing.getAndSet(true)) {
//        Single
//            .just("TOKEN!")
//            .delay(100, TimeUnit.MILLISECONDS)
//            .doAfterTerminate { executing.set(false) }
//    } else {
//        Single.error { InvalidStateException("") }
//    }
//}
//
//
//
//val pub = PublishSubject.create<String>()
//
//fun doLogin(): Single<String> {
//    return pub
//        .doOnSubscribe {
//            login().subscribe ({ str ->
//                pub.onNext(str)
//            }, {})
//        }
//        .firstOrError()
//}
//val mainThread = Schedulers.from(Executors.newSingleThreadExecutor())
//
//doLogin()
//    .subscribeOn(mainThread)
//    .subscribe({ println("1value = $it") }, {  })
//doLogin()
//    .subscribeOn(mainThread)
//    .subscribe({ println("2value = $it") }, {  })
//doLogin()
//    .subscribeOn(mainThread)
//    .subscribe({ println("3value = $it") }, {  })
//
//println("finished subscribing")
//
//Thread.sleep(5000)






sealed class AvatarEvent

sealed class AvatarEffect {
    object Effect1 : AvatarEffect()

    sealed class AvatarViewEffect : AvatarEffect() {
        object Effect2 : AvatarViewEffect()
    }
}





class NavigationEvent() {
    fun call(handler: Any) {

    }
}




class ViewModel {
//    fun accept(effect: AvatarViewEffect) {
//        when (effect) {
//            is AvatarViewEffect.Effect2 -> {}
//            // is AvatarEffect.Effect1
//        }
//    }
}

class AvatarEffectHandler(val viewModel: ViewModel) {

//    fun provideHandler(): (AvatarEffect) -> AvatarEvent? = { event ->
//        when (event) {
//            is AvatarEffect.Effect1 -> {/* do something */ null }
//            is AvatarViewEffect.Effect2 -> { viewModel.accept(event); null }
//        }
//    }

}



var ongoing = false
fun login() : Single<String> {
    return if (ongoing) Single.error(IllegalStateException("oops"))
    else {
        ongoing = true
        Single
            .just("")
            .delay(500, TimeUnit.MILLISECONDS)
            .doAfterTerminate { ongoing = false }
    }
}





class Accumulator<T>(private val values: List<T> = emptyList()) {
    private var used = AtomicBoolean(false)
    fun consume(handler: (T) -> Unit) {
        if (used.compareAndSet(false, true)) {
            values.forEach(handler)
        }
    }
    operator fun plus (value: T): Accumulator<T> {
        return if (used.get()) {
            Accumulator(listOf(value))
        } else {
            Accumulator(values + value)
        }
    }
}











//
//var completable = CompletableSubject.create()
//
//completable.subscribe( {println("one complete")}, {throwable ->  })
//
//completable.onComplete()
//
//completable.subscribe( {println("two complete")}, {throwable ->  })
//
//
//completable = CompletableSubject.create()
//
//completable.subscribe( {println("onex complete")}, {throwable ->  println("onex throw")})
//
//completable.onError(NullPointerException())
//
//completable.subscribe( {println("twox complete")}, {throwable ->  println("twox throw") })
//
//
//
//val ssa  = SingleSubject.create<String>()
//ssa.doAfterTerminate {  }



var FLAG_A = false
inner class Thinggetter {
    val isFlagA: Boolean
        get() = FLAG_A
}

val th = Thinggetter()
println(th.isFlagA)
FLAG_A = true
println(th.isFlagA)
