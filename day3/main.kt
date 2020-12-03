import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val inputLines = File(filePath).readLines()
    val area = AreaWithTrees(inputLines, '#')
    var position = MovingPosition(0, 0)

    //part 1
    println("part 1 result: " + countTrees(area, Toboggan(3, 1)))

    //part 2
    val toboggans = listOf(
        Toboggan(1, 1),
        Toboggan(3, 1),
        Toboggan(5, 1),
        Toboggan(7, 1),
        Toboggan(1, 2),
    )

    var treesMultiplied = 1L;
    for (toboggan in toboggans) {
        treesMultiplied = treesMultiplied * countTrees(area, toboggan)
    }
    println("part 2 result: " + treesMultiplied)

}

private fun countTrees(areaWithTrees: AreaWithTrees, toboggan: Toboggan): Int {
    var trees = 0;
    var position = MovingPosition(0, 0)
    while (areaWithTrees.hasPosition(position.x, position.y)) {
        if (areaWithTrees.hasTreeAtPosition(position.x, position.y)) {
            trees++
        }
        position = position.getNewPosition(toboggan)
    }
    return trees
}
