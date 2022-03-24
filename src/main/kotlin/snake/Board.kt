package snake

class Board(private val rowCount: Int, private val colCount: Int) {
    var cells: Array<Array<Cell>> = Array(rowCount) { row -> Array(colCount) { col -> Cell(row, col, CellType.EMPTY) } }

    fun generateFood() {
        println("Going to generate food")
        var row: Int
        var column: Int
        do {
            row = (Math.random() * rowCount).toInt()
            column = (Math.random() * colCount).toInt()
        } while (cells[row][column].cellType === CellType.SNAKE_NODE)
        cells[row][column].cellType = CellType.FOOD
        println("Food is generated at: $row $column")
    }

    fun showBoard() {
        for (i in cells.indices) {
            println(cells[i].map { arr -> arr.cellType.toString().padStart(10, ' ') })
        }
    }
}
