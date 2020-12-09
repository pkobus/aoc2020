import java.util.regex.Pattern
import kotlin.math.min

class GameConsole(var accumulator:Int) {

    private var executionIndex = -1;
    private val executed = HashSet<Int>()

    private val instructionPattern = Pattern.compile("(?<instruction>nop|acc|jmp) (?<sign>[\\-+])(?<number>\\d+)")

    fun executeInstructions(instructions: List<String>): ExecutionResult {
        executionIndex = 0
        accumulator = 0
        executed.clear()
        while (executed.add(executionIndex)) {
            var isLast = false
            if (executionIndex == instructions.size-1) {
                isLast = true
            }
            val matcher = instructionPattern.matcher(instructions[executionIndex])
            matcher.find()
            val instruction = matcher.group("instruction")
            val number = if (matcher.group("sign") == "-")  -matcher.group("number").toInt() else matcher.group("number").toInt()
            when (instruction) {
                "acc" -> {
                    accumulator += number
                    executionIndex ++
                }
                "jmp" -> {
                    executionIndex += number
                }
                "nop" -> {
                    executionIndex ++
                }
            }
            if (isLast) {
                return ExecutionResult.OK
            }


        }
        return ExecutionResult.LOOP
    }

    fun executeWithRepair(instructions: List<String>) {
        var repaired = false
        var lastIndexOfNopOrJmp = -1
        while (!repaired) {
            val instructionsToRepair = ArrayList<String>(instructions)
            lastIndexOfNopOrJmp ++
            lastIndexOfNopOrJmp += instructionsToRepair.subList(lastIndexOfNopOrJmp, instructionsToRepair.size).indexOfFirst { it.startsWith("nop") || it.startsWith("jmp") }
            instructionsToRepair[lastIndexOfNopOrJmp] = if (instructionsToRepair[lastIndexOfNopOrJmp].startsWith("nop")) instructionsToRepair[lastIndexOfNopOrJmp].replace("nop", "jmp") else instructionsToRepair[lastIndexOfNopOrJmp].replace("jmp", "nop")
            val result = executeInstructions(instructionsToRepair)
            if (result == ExecutionResult.OK) {
                repaired = true
            }
        }
    }

}