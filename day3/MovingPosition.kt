class MovingPosition (val x: Int, val y: Int){

    fun getNewPosition(movable: Movable): MovingPosition {
        return MovingPosition(x + movable.getXMoveLength(), y + movable.getYMoveLength())
    }

}