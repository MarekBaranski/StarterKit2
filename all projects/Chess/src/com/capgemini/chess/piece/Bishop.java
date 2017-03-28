package com.capgemini.chess.piece;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;

public class Bishop extends Piece {
	public Bishop(ColorPiece color) {
		super(color);

	}
	public Bishop(){
		
		
	}

	@Override
	public boolean moveIsPossible(Board board, int fromX, int fromY, int toX, int toY) {
		if (super.moveIsPossible(board, fromX, fromY, toX, toY) == true)

			if (moveForBishopIsPossible(board, fromX, fromY, toX, toY) == 0)

				return true;

		return false;
	}

	public int moveForBishopIsPossible(Board board, int fromX, int fromY, int toX, int toY) {
		int tempX = fromX - toX;
		int tempY = fromY - toY;
		int count = 0;
		if (tempX < 0 && tempY < 0) {
			for (int i = 1; i < Math.abs(tempX); i++) {

				if (board.getFieldStatus(fromX + 1, fromY + 1)) {

					count++;
				}
			}
		}
		if (tempX > 0 && tempY > 0) {
			for (int i = 1; i < Math.abs(tempX); i++) {

				if (board.getFieldStatus(fromX - 1, fromY - 1)) {

					count++;
				}
			}
		}

		if (tempX > 0 && tempY < 0) {
			for (int i = 1; i < Math.abs(tempX); i++) {

				if (board.getFieldStatus(fromX - i, fromY + i)) {
					count++;
				}
			}
		}
		if (tempX < 0 && tempY > 0) {
			for (int i = 1; i < Math.abs(tempX); i++) {

				if (board.getFieldStatus(fromX + 1, fromY - 1)) {

					count++;
				}
			}
		}
		return count;
	}

}
