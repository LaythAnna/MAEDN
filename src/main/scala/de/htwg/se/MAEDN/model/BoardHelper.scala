package model

object BoardHelper:

  def generateFields(): List[Field] =
    val board = Main.board

    val rowIndices = board.indices

    val allPositions =
      rowIndices.flatMap { y =>
        val colIndices = board(y).indices //
        colIndices.map { x =>
          Position(x, y)
        }
      }

    val filteredPositions = allPositions.filter(pos => board(pos.y)(pos.x) == "..")

    val resultList = filteredPositions.toList
    resultList.foreach(_ => ()) //

    resultList.map(pos => Field(pos, FieldType.Board))
