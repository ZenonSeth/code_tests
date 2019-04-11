package sync

//import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.stream.IntStream


fun main(args: Array<String>) {
    val syncMethods = SyncMethods()

    val service = Executors.newFixedThreadPool(17)
    //val rand = Random()

    IntStream.range(0, 1000)
            .forEach { count -> service.submit { if (count % 2 == 0) syncMethods.inc() else syncMethods.dec()} }

    service.awaitTermination(1000, TimeUnit.MILLISECONDS)

    println(syncMethods.count)

    service.shutdown()

}