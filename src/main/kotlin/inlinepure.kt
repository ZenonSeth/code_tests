
import kotlinx.coroutines.*
import java.lang.Thread.sleep


fun main() {
    GlobalScope.launch {
        val job1 = async(Dispatchers.IO) {
            println("job1 start")
            sleep(1000)
            println("job1 end")
        }

        val job2 = async(Dispatchers.IO) {
            println("job2 start")
            sleep(1000)
            println("job2 end")
        }

        println("Immediately after job1")
        delay(4000)
        println("Now awaiting for job1...")
        job1.await()
        println("Now awaiting for job2...")
        job2.await()
        println("Immediately after AWAIT")
    }
    sleep(20_000)
}














