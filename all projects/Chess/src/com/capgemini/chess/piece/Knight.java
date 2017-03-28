package com.capgemini.chess.piece;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;

public class Knight extends Piece {
	public Knight(ColorPiece color) {
		super(color);

	}

	@Override
	public boolean moveIsPossible(Board board, int fromX, int fromY, int toX, int toY) {
		if (super.moveIsPossible(board, fromX, fromY, toX, toY) == true)

			if (checkIfMoveForKnightIsPossible(fromX, fromY, toX, toY))
				return true;

		return false;
	}

	private boolean checkIfMoveForKnightIsPossible(int fromX, int fromY, int toX, int toY) {
		return (toX == (fromX + 2) && toY == (fromY + 1)) || (toX == (fromX + 2) && toY == (fromY - 1))
				|| (toX == (fromX - 2) && toY == (fromY - 1)) || (toX == (fromX - 2) && toY == (fromY + 1))
				|| (toY == (fromY + 2) && toX == (fromX + 1)) || (toY == (fromY + 2) && toX == (fromX - 1))
				|| (toY == (fromY - 2) && toX == (fromX - 1)) || (toY == (fromY - 2) && toX == (fromX + 1));
	}

}
