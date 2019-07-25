package twocolumns

import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.SingleSubject
import java.util.concurrent.TimeUnit


val publisher = PublishSubject.create<String>()

var done = false

publisher
    .debounce(1000L, TimeUnit.MILLISECONDS)
    .subscribe { println("subscriber called at " + System.currentTimeMillis()); done = true }


println(">> START " + System.currentTimeMillis())
publisher.onNext("test")

while (!done) {}


publisher.onComplete()



val single = Single.just(Math.random())

    single.subscribe { it: Double -> println("what 1? $it") }

    single.subscribe { it: Double -> println("what 2? $it") }


val singleSubj = SingleSubject.create<String>()

singleSubj.subscribe { s -> println("$s") }

singleSubj.onSuccess("success!")

singleSubj.subscribe { s -> println("$s") }


val behSub = BehaviorSubject.createDefault("empty")

behSub.subscribe { println(it) }

behSub.onNext("state 1")

behSub.onComplete()

behSub.hide()

behSub.subscribe ({ println(it) }, {println("err: $it")})