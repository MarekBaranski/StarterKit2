package com.capgemini.chess.piece;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;

public class Queen extends Piece {
	public Queen(ColorPiece color) {
		super(color);

	}

	Rock rock = new Rock();
	Bishop bishop = new Bishop();

	@Override
	public boolean moveIsPossible(Board board, int fromX, int fromY, int toX, int toY) {
		if (super.moveIsPossible(board, fromX, fromY, toX, toY) == true)
			if ((toX == fromX && toY != fromY) || (toX != fromX && toY == fromY)
					|| (Math.abs(toX - fromX) == Math.abs(toY - fromY)))
				if (rock.moveForRockIsPossible(board, fromX, fromY, toX, toY) == 0)
					if (bishop.moveForBishopIsPossible(board, fromX, fromY, toX, toY) == 0)
						return true;

		return false;
	}

}
