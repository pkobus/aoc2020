import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val lines = File(filePath).readLines()
    val console = GameConsole(0)
    //part 1
    console.executeInstructions(lines)
    println(console.accumulator)
    //part 2
    console.executeWithRepair(lines)
    println(console.accumulator)

}