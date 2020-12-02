import java.io.File
import java.util.regex.Pattern
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 * 1 - 1 or 2 number of part of task
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val inputLines = File(filePath).readLines()
    val compile = Pattern.compile("(?<low>\\d+)-(?<high>\\d+) (?<char>\\w): (?<password>\\w+)")
    val count = inputLines.count {
        val matcher = compile.matcher(it)
        matcher.find()
        val nptrsPassword = NPTRSPassword(
                matcher.group("low").toInt(),
                matcher.group("high").toInt(),
                matcher.group("char").toCharArray()[0],
                matcher.group("password")
        )
        when {
            args[1] == "1" -> {
                nptrsPassword.isValidForPart1()
            }
            args[1] == "2" -> {
                nptrsPassword.isValidForPart2()
            }
            else -> {
                throw IllegalArgumentException(String.format("Invalid arg for part type %s", args[1]))
            }
        }
    }
    println(count)

}
