import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val lines = File(filePath).readLines()
    val rules = Rules(lines)
    //part 1
    println(rules.countPath("shiny gold"))
    //part 2
    println(rules.countInnerBags("shiny gold") - 1)

}