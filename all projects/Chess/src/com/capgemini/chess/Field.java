package com.capgemini.chess;

import com.capgemini.chess.piece.Piece;

public class Field {

	private boolean isOccupied;
	private Piece piece;

	public Field(boolean isOccupied) {

		this.isOccupied = isOccupied;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
