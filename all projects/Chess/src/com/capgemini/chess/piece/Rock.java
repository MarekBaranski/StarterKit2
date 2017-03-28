package com.capgemini.chess.piece;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;

public class Rock extends Piece {
	public Rock(ColorPiece color) {
		super(color);

	}

	public Rock() {

	}

	@Override
	public boolean moveIsPossible(Board board, int fromX, int fromY, int toX, int toY) {
		if (super.moveIsPossible(board, fromX, fromY, toX, toY) == true)
			if ((toX == fromX && toY != fromY) || (toX != fromX && toY == fromY))
				if (moveForRockIsPossible(board, fromX, fromY, toX, toY) == 0)
					return true;

		return false;
	}

	public int moveForRockIsPossible(Board board, int fromX, int fromY, int toX, int toY) {
		int tempX = fromX - toX;
		int tempY = fromY - toY;
		int count = 0;
		if (tempX == 0 && tempY < 0) {

			for (int i = fromY + 1; i < toY; i++) {

				if (board.getFieldStatus(fromX, i)) {

					count++;
				}
			}
		}

		if (tempX == 0 && tempY > 0) {

			for (int i = fromY - 1; i > toY; i--) {

				if (board.getFieldStatus(fromX, i)) {

					count++;
				}
			}
		}

		if (tempY == 0 && tempX > 0) {

			for (int i = fromX - 1; i > toX; i--) {

				if (board.getFieldStatus(i, fromY)) {

					count++;
				}
			}
		}
		if (tempY == 0 && tempX < 0) {

			for (int i = fromX + 1; i < toX; i++) {
				if (board.getFieldStatus(i, fromY)) {

					count++;
				}
			}
		}
		return count;
	}

}
