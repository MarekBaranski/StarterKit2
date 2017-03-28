package com.capgemini.chess.piece;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;

public abstract class Piece {

	private ColorPiece color;

	public Piece(ColorPiece color) {

		this.color = color;
	}

	public Piece() {

	}

	public ColorPiece getColor() {
		return color;
	}

	public void setColor(ColorPiece color) {
		this.color = color;
	}

	public boolean moveIsPossible(Board board, int fromX, int fromY, int toX, int toY) {

		if (board.getFieldStatus(fromX, fromY) && checkIfCoordsAreOutOfArray(fromX, fromY, toX, toY)) {
			return true;
		}
		return false;
	}

	private boolean checkIfCoordsAreOutOfArray(int fromX, int fromY, int toX, int toY) {
		if ((fromX >= 0 && fromX <= 7) && (fromY >= 0 && fromY <= 7) && (toX >= 0 && toX <= 7)
				&& (toY >= 0 && toY <= 7)) {
			return true;
		}
		return false;
	}

}
