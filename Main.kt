


val FIR_board = FourInARow()

/** The entry main method (the program starts here)  */
fun main() {
 var currentState: Int = GameConstants.PLAYING
 var userInput = ""
 //game loop
 do {
    FIR_board.printBoard()
    userInput = readln()
    if(userInput != "q" && userInput != "c") {
     FIR_board.setMove(0,userInput.toInt())
    if(FIR_board.checkForWinner() == 1) {
     currentState = GameConstants.BLUE_WON
     FIR_board.printBoard()
     println("Blue wins!")
    }
     FIR_board.setMove(1,FIR_board.computerMove)
    if(FIR_board.checkForWinner() == 2) {
     currentState = GameConstants.RED_WON
     FIR_board.printBoard()
     println("Red wins!")
    }
   }
  if(userInput == "c") {
   FIR_board.clearBoard()
  }

 } while (currentState == GameConstants.PLAYING && userInput != "q")
// repeat if not game-over
}