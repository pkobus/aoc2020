class AreaWithTrees(private val areaLines: List<String>, private val treeChar: Char) {

    private val patternLength = areaLines[0].length
    private val height = areaLines.size

    fun hasTreeAtPosition(x: Int, y: Int): Boolean {
        return areaLines[y][x % patternLength] == treeChar
    }

    fun hasPosition(x: Int, y: Int): Boolean {
        return height > y
    }

}