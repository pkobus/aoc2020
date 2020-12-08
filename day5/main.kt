import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val lines = File(filePath).readLines()
    val boardingPasses = lines.map {
        BoardingPass(it)
    }
    part1(boardingPasses)
    part2(boardingPasses)
}

private fun part2(boardingPasses: List<BoardingPass>) {
    val inMax = boardingPasses.maxOf { it.getRowId() }
    for (i in boardingPasses.indices) {
        val first = boardingPasses[i].getRowId()
        val second = first + 1
        var nextExists = false
        for (j in boardingPasses.indices) {
            if (boardingPasses[j].getRowId() == second) {
                nextExists = true
            }
        }
        if (!nextExists && first != inMax) {
            println("Your seat id is $second")
        }
    }
}

private fun part1(boardingPasses: List<BoardingPass>) {
    val max = boardingPasses.maxOf { it.getRowId() }
    println("Max seat id is: $max")
}