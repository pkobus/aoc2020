import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val numbers = File(filePath).readLines().map { it.toLong() }
    val preamble = 25
    for (i in preamble until numbers.size) {
        val number = numbers[i]
        val preambleList = numbers.subList(i - preamble, i)
        if (!isAnySumOfTwoPrevious(number, preambleList)) {
            //part 1
            println(number)
            //part 2
            println(findEncryptionWeakness(number, numbers))
        }
    }
}

fun findEncryptionWeakness(number: Long, preambleList: List<Long>): Long {
    var first = 0
    var last = 0
    for (i in preambleList.indices) {
        var counterNumber = number - preambleList[i]
        if (counterNumber > 0) {
            for (j in i+1 until preambleList.size) {
                counterNumber -= preambleList[j]
                if (counterNumber < 0) {
                    break
                } else if (counterNumber == 0L) {
                    first = i
                    last = j
                }
            }
        } else {
            continue
        }
    }
    val subList = preambleList.subList(first, last)
    return subList.minOrNull()!! + subList.maxOrNull()!!
}

fun isAnySumOfTwoPrevious(number: Long, subList: List<Long>): Boolean {
    for (i in subList.indices) {
        for (j in subList.indices) {
            if (i != j && number == subList[i] + subList[j]){
                return true
            }
        }
    }
    return false
}