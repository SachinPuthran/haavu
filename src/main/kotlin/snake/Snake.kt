package snake

class Snake(var head: Cell) {
    var snakePartList: MutableList<Cell> = mutableListOf()

    init {
        snakePartList.add(head)
        head.cellType = CellType.SNAKE_NODE
    }

    fun grow() = snakePartList.add(head)

    fun move(nextCell: Cell) {
        println("Snake is moving to ${nextCell.row} ${nextCell.column}")
        val tail = snakePartList.removeLast()
        tail.cellType = CellType.EMPTY

        head = nextCell
        head.cellType = CellType.SNAKE_NODE
        snakePartList.add(0, head)
    }

    fun checkCrash(nextCell: Cell) = snakePartList.contains(nextCell)
}
