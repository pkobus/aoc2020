class Toboggan (private val x: Int, private val y: Int): Movable {

    override fun getXMoveLength(): Int {
        return x;
    }

    override fun getYMoveLength(): Int {
        return y;
    }

}