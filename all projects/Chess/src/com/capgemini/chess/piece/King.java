package com.capgemini.chess.piece;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;

public class King extends Piece {

	public King(ColorPiece color) {
		super(color);

	}

	@Override
	public boolean moveIsPossible(Board board, int fromX, int fromY, int toX, int toY) {
		if (super.moveIsPossible(board, fromX, fromY, toX, toY) == true)

			if ((toX == fromX + 1 || toX == fromX - 1) && (toY == fromY + 1 || toY == fromY - 1)
					|| (toX == fromX && (toY == fromY + 1 || toY == fromY - 1))
					|| (toY == fromY && (toX == fromX + 1 || toX == fromX - 1)))

				return true;

		return false;
	}

}
