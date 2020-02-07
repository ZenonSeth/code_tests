import io.reactivex.subjects.PublishSubject
import java.lang.NullPointerException

{}.fun Function<*>.() {}();


{}.fun (()->Unit).(){}()


"".fun String.() {}()


//TODO().fun Nothing.(){}()









class InlineCaller(val callMe: AnInlineClass) {
    fun other() {
        callMe.dothing { 5 }
    }
}

class AnInlineClass(val a: (Int) -> Int) {
    inline fun dothing(intProvider: () -> Int) {
        println("" + a(intProvider()))
    }
}











val subk: PublishSubject<String> = PublishSubject.create()
subk.onError(NullPointerException("hey now"))


