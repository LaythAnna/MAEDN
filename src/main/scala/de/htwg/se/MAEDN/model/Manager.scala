package de.htwg.se.MAEDN.model

import de.htwg.se.MAEDN.controller.Controller
import de.htwg.se.MAEDN.model.IState
import de.htwg.se.MAEDN.model.states.MenuState
import de.htwg.se.MAEDN.util.Color

trait Manager extends IState {

  val moves: Int = 0
  val board: Board = BoardFactory().build()
  val players: List[Player] = {
    List(Color.RED, Color.BLUE).zipWithIndex.map { case (color, index) =>
      val placeholder = Player(index + 1, List.empty, color)
      val figures = (1 to 4).map(i => Figure(i, placeholder)).toList
      placeholder.copy(figures = figures)
    }
  }
  def increaseBoardSize(): Manager = this
  def decreaseBoardSize(): Manager = this
  def increaseFigures(): Manager = this
  def decreaseFigures(): Manager = this
  def moveUp(): Manager = this
  def moveDown(): Manager = this
  def playDice(): Manager = this
  def playNext(): Manager = this
  def quitGame(): Manager = this
  def startGame(): Manager = this
  def moveFigure(): Manager = this

  def getPlayerCount: Int = players.size
  def getFigureCount: Int = players.head.figures.size
  def getBoardSize: Int = board.size
  def getCurrentPlayer: Int = moves % players.size
}

object Manager {
  def apply(controller: Controller): Manager =
    MenuState(
      controller,
      0,
      BoardFactory().build(),
      List(Color.RED, Color.BLUE).zipWithIndex.map { case (color, index) =>
        val placeholder = Player(index + 1, List.empty, color)
        val figures = (1 to 4).map(i => Figure(i, placeholder)).toList
        placeholder.copy(figures = figures)
      }
    )
}
