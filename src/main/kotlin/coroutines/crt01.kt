package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.FileReader
import java.io.FileWriter

fun main() {

    FileWriter("a.txt").write("fileA")
    FileWriter("b.txt").write("fileB")

    GlobalScope.launch {
        val a = readFrom("a.txt")
        val b = readFrom("b.txt")
        val out = a + b
        println("Out = $out")
        println("Done!")
    }

}

fun readFrom(name: String) : String {
    return FileReader(name).readLines().joinToString { it }
}