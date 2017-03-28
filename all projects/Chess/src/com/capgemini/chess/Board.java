package com.capgemini.chess;

import com.capgemini.chess.piece.Pawn;
import com.capgemini.chess.piece.Piece;

public class Board {

	private Field[][] board;

	public Board() {
		board = new Field[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new Field(false);
			}
		}

	}

	public boolean getFieldStatus(int x, int y) {
		return board[x][y].isOccupied();
	}

	public void setFieldStatus(int x, int y, boolean isOccupied) {
		board[x][y].setOccupied(isOccupied);
	}

	public void makeMove(Board board, int fromX, int fromY, int toX, int toY, Piece piece) {
		Piece currentPiece = board.getPieceFromBoard(fromX, fromY);
		Piece targetPiece = board.getPieceFromBoard(toX, toY);
		boolean targetFieldStatus = board.getFieldStatus(toX, toY);

		if (piece.moveIsPossible(board, fromX, fromY, toX, toY) == true) {
			if (!targetFieldStatus || currentPiece.getColor() != targetPiece.getColor())

				if (!(currentPiece.getClass().equals(Pawn.class))) {
					changeStatusStartAndTarget(board, fromX, fromY, toX, toY, currentPiece);
				} else {
					if (targetFieldStatus == false) {
						changeStatusStartAndTarget(board, fromX, fromY, toX, toY, currentPiece);
					}
					if (toX - fromX == 1 && targetFieldStatus == true && (currentPiece.getClass().equals(Pawn.class))) {
						changeStatusStartAndTarget(board, fromX, fromY, toX, toY, currentPiece);
					}
				}
		}
	}

	private void changeStatusStartAndTarget(Board board, int fromX, int fromY, int toX, int toY, Piece currentPiece) {

		board.addPieceToField(toX, toY, currentPiece);
		board.setFieldStatus(fromX, fromY, false);
		board.setFieldStatus(toX, toY, true);
	}

	public Piece getPieceFromBoard(int x, int y) {
		return board[x][y].getPiece();
	}

	public void addPieceToField(int toX, int toY, Piece piece) {

		board[toX][toY].setPiece(piece);
		board[toX][toY].setOccupied(true);

	}

}