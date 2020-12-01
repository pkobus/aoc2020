import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 * 2 - expected sum result
 * 3 - entries that sum to previous param
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val sumResult = args[1].toInt()
    val numberOfNumbers = args[2].toInt()
    val inputLines = File(filePath).readLines().map { it.toInt() }
    val arr = findForNumber(inputLines.toIntArray(), numberOfNumbers, sumResult)
    println(arr.reduce { acc, i -> acc * i })
}

private fun findForNumber(inputLines: IntArray, numberOfNumbers: Int, expected: Int): IntArray {
    if (numberOfNumbers == 1) {
        return findMatch(inputLines, expected)
    }
    return findForNextNumbers(inputLines, numberOfNumbers, expected)
}

private fun findMatch(inputLines: IntArray, expected: Int): IntArray {
    if (inputLines.contains(expected)) {
        return IntArray(1) { expected }
    }
    return IntArray(0)
}

private fun findForNextNumbers(inputLines: IntArray, numberOfNumbers: Int, expected: Int): IntArray {
    for (i in inputLines.indices) {
        val reducedExpected = expected - inputLines[i]
        if (reducedExpected > 0) {
            val findForNumber = findForNumber(takLastFromIndex(inputLines, i), numberOfNumbers - 1, reducedExpected)
            if (findForNumber.isNotEmpty()) {
                return findForNumber.plus(inputLines[i]);
            }
        }
    }
    return IntArray(0)
}

private fun takLastFromIndex(inputLines: IntArray, i: Int) =
        inputLines.takeLast(inputLines.size - i - 1).toIntArray()
