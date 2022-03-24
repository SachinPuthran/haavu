package snake

class Game(var snake: Snake, var board: Board) {
    var direction = Direction.NONE
    var gameOver = false

    fun update() {
        println("Going to update the game")
        if (!gameOver && direction != Direction.NONE) {
            val nextCell = getNextCell(snake.head)
            if (snake.checkCrash(nextCell)) {
                direction = Direction.NONE
                gameOver = true
            } else {
                if (nextCell.cellType === CellType.FOOD) {
                    snake.grow()
                    board.generateFood()
                    println("Ate food. Snake is now ${snake.snakePartList.size} long")
                }
                snake.move(nextCell)
                board.showBoard()
            }
        }
    }

    private fun getNextCell(currentPosition: Cell): Cell {
        println("Going to find next cell")
        var row = currentPosition.row
        var col = currentPosition.column
        when (direction) {
            Direction.RIGHT -> { col++ }
            Direction.LEFT -> { col-- }
            Direction.UP -> { row-- }
            Direction.DOWN -> { row++ }
            else -> {}
        }
        return board.cells[row][col]
    }
}
