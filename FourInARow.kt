import kotlin.random.Random

/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 2/12/2022
 */
class FourInARow
/**
 * clear board and set current player
 */
    : IGame {
    // game board in 2D array initialized to zeros
    private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS){0} }

    override fun clearBoard() {
        for(i in board.indices) {
            for(j in board[i].indices) {
                board[i][j] = 0;
            }
        }
    }

    override fun setMove(player: Int, location: Int) {
        var cpLocation = computerMove
        // PLAYER
        if(board[location/6][location%6] == 0 && player == 0) { board[location / 6][location % 6] = 1 }
        else if(player == 0){
            println("That position is taken!")
            setMove(0,readln().toInt())
        }
        // COMPUTER
        while(board[cpLocation/6][cpLocation%6] != 0) { cpLocation = computerMove }
        if(player == 1) { board[cpLocation / 6][cpLocation % 6] = 2 }
    }

    override val computerMove: Int
        get() = Random.nextInt(0,36)

    override fun checkForWinner(): Int {
        //Check right
        for(i in board.indices) {
            for(j in 0 until 2) {
                if(board[i][j] != 0) {
                    if(board[i][j] == 1 && board[i][j+1] == 1 && board[i][j+2] == 1 && board[i][j+3] == 1) { return 1; }
                    if(board[i][j] == 2 && board[i][j+1] == 2 && board[i][j+2] == 2 && board[i][j+3] == 2) { return 2; }
                }
            }
        }
        //Check down
        for(i in board.indices) {
            for(j in 0 until 2) {
                if(board[i][j] != 0) {
                    if(board[j][i] == 1 && board[j+1][i] == 1 && board[j+2][i] == 1 && board[j+3][i] == 1) { return 1; }
                    if(board[j][i] == 2 && board[j+1][i] == 2 && board[j+2][i] == 2 && board[j+3][i] == 2) { return 2; }
                }
            }
        }
        //Check diagonal
        for(i in board.indices) {
            for(j in 0 until 2) {
                try {
                    if(board[i][j] != 0) {
                        if(board[i][j] == 1 && board[i+1][j+1] == 1 && board[i+2][j+2] == 1 && board[i+3][j+3] == 1) { return 1; }
                        if(board[i][j] == 2 && board[i+1][j+1] == 2 && board[i+2][j+2] == 2 && board[i+3][j+3] == 2) { return 2; }
                        if(board[j][i] == 1 && board[j+1][i+1] == 1 && board[j+2][i+2] == 1 && board[j+3][i+3] == 1) { return 1; }
                        if(board[j][i] == 2 && board[j+1][i+1] == 2 && board[j+2][i+2] == 2 && board[j+3][i+3] == 2) { return 2; }
                    }
                } catch (e: ArrayIndexOutOfBoundsException) {

                }
            }
        }
        return 0
    }

    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells
                if (col != GameConstants.COLS - 1) {
                    print("|") // print vertical partition
                }
            }
            println()
            if (row != GameConstants.ROWS - 1) {
                println("-----------------------") // print horizontal partition
            }
        }
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" B ")
            GameConstants.RED -> print(" R ")
        }
    }
}

