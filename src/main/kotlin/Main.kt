import snake.*

fun main() {
    println("Going to start game")
    val game = Game(Snake(Cell(0, 0, CellType.SNAKE_NODE)), Board(5, 5))
    game.gameOver = false
    game.board.generateFood()

    while (true) {
        println("Enter direction: U, D, L, R")
        when (readLine()!!.uppercase()) {
            "U" -> {
                game.direction = Direction.UP
                game.update()
            }
            "D" -> {
                game.direction = Direction.DOWN
                game.update()
            }
            "L" -> {
                game.direction = Direction.LEFT
                game.update()
            }
            "R" -> {
                game.direction = Direction.RIGHT
                game.update()
            }
            else -> {
                println(game.snake.snakePartList.map { part -> "(${part.row}, ${part.column})" })
            }
        }
    }
}
