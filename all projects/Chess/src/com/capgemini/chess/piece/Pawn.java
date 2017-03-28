package com.capgemini.chess.piece;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;

public class Pawn extends Piece {
	public Pawn(ColorPiece color) {
		super(color);

	}

	@Override
	public boolean moveIsPossible(Board board, int fromX, int fromY, int toX, int toY) {

		if (super.moveIsPossible(board, fromX, fromY, toX, toY) == true) {

			if ((toX == fromX) && (toY == fromY + 1) && ((board.getFieldStatus(fromX, fromY + 1) == false)))
				return true;

			if (chackIfPawnMoveDiagonally(board, fromX, fromY, toX, toY))
				return true;
		}
		return false;
	}

	private boolean chackIfPawnMoveDiagonally(Board board, int fromX, int fromY, int toX, int toY) {
		if (((board.getFieldStatus(fromX - 1, fromY + 1)) || (board.getFieldStatus(fromX + 1, fromY + 1)))
				&& (board.getPieceFromBoard(fromX, fromY).getColor() != board.getPieceFromBoard(toX, toY).getColor()))
			return true;
		return false;
	}

}
