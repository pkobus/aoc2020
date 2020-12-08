import java.lang.RuntimeException
import java.util.*

class BoardingPass(line: String) {

    private val column: Int
    private val row: Int

    init {
        row = calculateByDivide(line.substring(0, 7), 0, 127, 'B', 'F')
        column = calculateByDivide(line.substring(7), 0, 7, 'R', 'L')
    }

    private fun calculateByDivide(columnInfo: String, inMin: Int, inMax: Int, upperChar: Char, lowerChar: Char): Int {
        val columnQueue: Queue<Char> = LinkedList()
        columnInfo.forEach { columnQueue.offer(it) }
        var min = inMin + 1
        var max = inMax + 1
        var diff = max
        while (!columnQueue.isEmpty()) {
            val poll = columnQueue.poll()
            diff /= 2
            if (diff == 1 && poll == upperChar) {
                return max - 1
            } else if (diff == 1 && poll == lowerChar) {
                return min - 1
            } else if (diff > 1 && poll == lowerChar) {
                max -= diff
            } else if (diff > 1 && poll == upperChar) {
                min += diff
            }
        }
        throw RuntimeException()
    }

    fun getRowId(): Int {
        return row * 8 + column
    }
}
