import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val lines = File(filePath).readLines()
    var tail = lines
    val groups = ArrayList<List<String>>()
    while (tail.isNotEmpty()) {
        val toIndex = if (tail.indexOf("")  == -1) tail.size else tail.indexOf("")
        groups.add(tail.subList(0, toIndex))
        tail = if (toIndex < tail.size){
            tail.subList(toIndex +1 , tail.size)
        } else {
            emptyList()
        }
    }


    var sumOfAnswers = 0
    var sum2 = 0
    for (group in groups) {
        val mapOfAnswersCountedAnswers = HashMap<Char, Int>()
        val setOfAnswers = HashSet<Char>()
        for (answers in group) {
            for (answer in answers) {
                if(mapOfAnswersCountedAnswers.containsKey(answer)) {
                    mapOfAnswersCountedAnswers[answer] = mapOfAnswersCountedAnswers[answer]!!.plus(1)
                } else {
                    mapOfAnswersCountedAnswers[answer] = 0
                }
                setOfAnswers.add(answer)
            }
        }
        sum2 += mapOfAnswersCountedAnswers.count { it.value == group.size-1 }
        sumOfAnswers += setOfAnswers.size
    }
    //part 1
    println(sumOfAnswers)
    //part 2
    println(sum2)
}