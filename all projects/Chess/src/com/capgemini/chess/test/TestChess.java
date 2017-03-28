package com.capgemini.chess.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.chess.Board;
import com.capgemini.chess.enums.ColorPiece;
import com.capgemini.chess.piece.Bishop;
import com.capgemini.chess.piece.King;
import com.capgemini.chess.piece.Knight;
import com.capgemini.chess.piece.Pawn;
import com.capgemini.chess.piece.Queen;
import com.capgemini.chess.piece.Rock;

public class TestChess {

	Board board;

	@Before
	public void setUp() {

		board = new Board();
	}

	@Test
	public void shouldCreateBoard() {

		board.getFieldStatus(3, 4);
		Assert.assertFalse(board.getFieldStatus(3, 4));
		board.setFieldStatus(3, 4, true);
		Assert.assertTrue(board.getFieldStatus(3, 4));

	}

	@Test
	public void shouldCreatePiece() {

		King king = new King(ColorPiece.WHITE);
		Assert.assertFalse(board.getFieldStatus(3, 4));
		board.addPieceToField(3, 4, king);

		Assert.assertTrue(board.getFieldStatus(3, 4));
	}

	@Test
	public void shouldTestPieceMakeMoveWhenFieldsIsEmpty() {

		King king = new King(ColorPiece.BLACK);

		board.makeMove(board, 3, 4, 4, 3, king);
		Assert.assertFalse(board.getFieldStatus(3, 4));
		Assert.assertFalse(board.getFieldStatus(4, 3));
	}

	@Test
	public void shouldTestMakeMoveWhenTargetPossitionIsOccuped() {

		Rock whiteRock = new Rock(ColorPiece.WHITE);
		Rock blackRock = new Rock(ColorPiece.BLACK);

		board.addPieceToField(2, 5, whiteRock);
		board.addPieceToField(6, 5, blackRock);
		board.makeMove(board, 2, 5, 6, 5, whiteRock);
		Assert.assertTrue(board.getFieldStatus(6, 5));
		Assert.assertEquals(board.getPieceFromBoard(6, 5).getColor().WHITE, board.getPieceFromBoard(6, 5).getColor());

	}

	@Test
	public void shouldTestBishopMakeMoveToLeftUp() {

		Bishop bishop = new Bishop(ColorPiece.WHITE);

		board.addPieceToField(5, 4, bishop);
		board.makeMove(board, 5, 4, 2, 7, bishop);
		Assert.assertTrue(board.getFieldStatus(2, 7));

	}

	@Test
	public void shouldTestBishopMakeMoveToRightUp() {

		Bishop bishop = new Bishop(ColorPiece.WHITE);

		board.addPieceToField(5, 4, bishop);
		board.makeMove(board, 5, 4, 7, 6, bishop);
		Assert.assertTrue(board.getFieldStatus(7, 6));

	}

	@Test
	public void shouldTestBishopMakeMoveToRightDown() {

		Bishop bishop = new Bishop(ColorPiece.WHITE);

		board.addPieceToField(3, 4, bishop);
		board.makeMove(board, 3, 4, 6, 1, bishop);
		Assert.assertTrue(board.getFieldStatus(6, 1));
	}

	@Test
	public void shouldTestBishopMakeMoveToLeftDown() {

		Bishop bishop = new Bishop(ColorPiece.WHITE);

		board.addPieceToField(4, 5, bishop);
		board.makeMove(board, 4, 5, 0, 1, bishop);
		Assert.assertTrue(board.getFieldStatus(0, 1));
	}

	@Test
	public void shouldTestBishopMakeMoveWhenFieldsBetweenAreOccuped() {

		Bishop bishop = new Bishop(ColorPiece.WHITE);
		Queen queen = new Queen(ColorPiece.BLACK);

		board.addPieceToField(6, 5, bishop);
		board.addPieceToField(4, 3, queen);

		board.makeMove(board, 6, 5, 1, 0, bishop);
		Assert.assertFalse(board.getFieldStatus(6, 5));
		Assert.assertTrue(board.getFieldStatus(1, 0));

	}

	@Test
	public void shouldTestBishopMakeMoveIsUnpossible() {

		Bishop bishop = new Bishop(ColorPiece.WHITE);

		board.addPieceToField(4, 4, bishop);
		board.makeMove(board, 4, 4, 0, 1, bishop);
		Assert.assertTrue(board.getFieldStatus(0, 1));
	}

	@Test
	public void shouldTestRockMakeMoveToUp() {

		Rock rock = new Rock(ColorPiece.WHITE);

		board.addPieceToField(3, 5, rock);
		board.makeMove(board, 3, 5, 3, 7, rock);
		Assert.assertFalse(board.getFieldStatus(3, 5));

	}

	@Test
	public void shouldTestRockMakeMoveToDown() {

		Rock rock = new Rock(ColorPiece.WHITE);

		board.addPieceToField(3, 5, rock);
		board.makeMove(board, 3, 5, 3, 2, rock);
		Assert.assertFalse(board.getFieldStatus(3, 5));

	}

	@Test
	public void shouldTestRockMakeMoveToLeft() {

		Rock rock = new Rock(ColorPiece.WHITE);

		board.addPieceToField(3, 5, rock);
		board.makeMove(board, 3, 5, 0, 5, rock);
		Assert.assertFalse(board.getFieldStatus(3, 5));

	}

	@Test
	public void shouldTestRockMakeMoveToRight() {

		Rock rock = new Rock(ColorPiece.WHITE);

		board.addPieceToField(3, 5, rock);
		board.makeMove(board, 3, 5, 7, 5, rock);
		Assert.assertFalse(board.getFieldStatus(3, 5));

	}

	@Test
	public void shouldTestRockMakeMoveWhenFieldsBetweenAreOccuped() {

		Rock rock = new Rock(ColorPiece.WHITE);
		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 3, rock);
		board.addPieceToField(4, 5, rock);
		board.makeMove(board, 4, 3, 4, 7, rock);
		Assert.assertFalse(board.getFieldStatus(4, 7));
		Assert.assertTrue(board.getFieldStatus(4, 3));

	}

	@Test
	public void shouldTestRockMakeMoveWhenFieldsBetweenIsOccuped() {

		Rock rock = new Rock(ColorPiece.WHITE);
		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(7, 4, rock);
		board.addPieceToField(5, 4, rock);
		board.makeMove(board, 7, 4, 1, 4, rock);
		Assert.assertFalse(board.getFieldStatus(1, 4));
		Assert.assertTrue(board.getFieldStatus(7, 4));

	}

	@Test
	public void shouldTestRockMakeMoveIsUnpossible() {

		Rock rock = new Rock(ColorPiece.WHITE);

		board.addPieceToField(3, 5, rock);
		board.makeMove(board, 3, 5, 6, 2, rock);
		Assert.assertFalse(board.getFieldStatus(6, 2));

	}

	@Test
	public void shouldTestQueenMakeMoveToRight() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 6, 4, queen);
		Assert.assertTrue(board.getFieldStatus(6, 4));

	}

	@Test
	public void shouldTestQueenMakeMoveToLeft() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 2, 4, queen);
		Assert.assertTrue(board.getFieldStatus(2, 4));

	}

	@Test
	public void shouldTestQueenMakeMoveToUp() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 4, 7, queen);
		Assert.assertTrue(board.getFieldStatus(4, 7));

	}

	@Test
	public void shouldTestQueenMakeMoveToDown() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 4, 1, queen);
		Assert.assertTrue(board.getFieldStatus(4, 1));

	}

	@Test
	public void shouldTestQueenMakeMoveToLeftDown() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 1, 1, queen);
		Assert.assertTrue(board.getFieldStatus(1, 1));

	}

	@Test
	public void shouldTestQueenMakeMoveToRightDown() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 7, 1, queen);
		Assert.assertTrue(board.getFieldStatus(7, 1));

	}

	@Test
	public void shouldTestQueenMakeMoveToRightUp() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 6, 6, queen);
		Assert.assertTrue(board.getFieldStatus(6, 6));

	}

	@Test
	public void shouldTestQueenMakeMoveToLeftUp() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 1, 7, queen);
		Assert.assertTrue(board.getFieldStatus(1, 7));

	}

	@Test
	public void shouldTestQueenMakeMoveIsUnpossible() {

		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(4, 4, queen);
		board.makeMove(board, 4, 4, 2, 5, queen);
		Assert.assertFalse(board.getFieldStatus(2, 5));

	}

	@Test
	public void shouldTestQueenMakeMoveWhenFieldsBetweenIsOccuped() {

		Rock rock = new Rock(ColorPiece.WHITE);
		Queen queen = new Queen(ColorPiece.WHITE);

		board.addPieceToField(7, 4, queen);
		board.addPieceToField(5, 4, rock);
		board.makeMove(board, 7, 4, 1, 4, queen);
		Assert.assertFalse(board.getFieldStatus(1, 4));
		Assert.assertTrue(board.getFieldStatus(7, 4));

	}

	@Test
	public void shouldTestPawnMakeMoveDiagonally() {

		Pawn pawn = new Pawn(ColorPiece.WHITE);
		Knight knight = new Knight(ColorPiece.BLACK);

		board.addPieceToField(1, 6, pawn);
		board.addPieceToField(2, 7, knight);
		board.makeMove(board, 1, 6, 2, 7, pawn);
		Assert.assertFalse(board.getFieldStatus(1, 6));

	}

	@Test
	public void shouldTestPawnMakeMove() {

		Pawn pawn = new Pawn(ColorPiece.WHITE);

		board.addPieceToField(6, 5, pawn);
		board.makeMove(board, 6, 5, 6, 6, pawn);
		Assert.assertFalse(board.getFieldStatus(6, 5));
	}

	@Test
	public void shouldTestPawnMakeMoveIsUnpossible() {

		Pawn pawn = new Pawn(ColorPiece.WHITE);

		board.addPieceToField(6, 5, pawn);
		board.makeMove(board, 6, 5, 7, 5, pawn);
		Assert.assertTrue(board.getFieldStatus(6, 5));

	}

	@Test
	public void shouldTestPawnMakeMoveWhenTargetFieldIsOccupied() {

		Pawn pawn = new Pawn(ColorPiece.WHITE);
		Queen queen = new Queen(ColorPiece.BLACK);

		board.addPieceToField(6, 5, pawn);
		board.addPieceToField(6, 6, queen);
		board.makeMove(board, 6, 5, 6, 6, pawn);
		Assert.assertTrue(board.getFieldStatus(6, 5));

	}

	@Test
	public void shouldTestKnightMakeMoveToLeft() {

		Knight knight = new Knight(ColorPiece.WHITE);

		board.addPieceToField(4, 4, knight);
		board.makeMove(board, 4, 4, 2, 3, knight);
		Assert.assertTrue(board.getFieldStatus(2, 3));

	}

	@Test
	public void shouldTestKnightMakeMoveToRight() {

		Knight knight = new Knight(ColorPiece.WHITE);

		board.addPieceToField(3, 4, knight);
		board.makeMove(board, 3, 4, 5, 5, knight);
		Assert.assertTrue(board.getFieldStatus(5, 5));

	}

	@Test
	public void shouldTestKnightMakeMoveToUp() {

		Knight knight = new Knight(ColorPiece.WHITE);

		board.addPieceToField(4, 3, knight);
		board.makeMove(board, 4, 3, 3, 5, knight);
		Assert.assertTrue(board.getFieldStatus(3, 5));

	}

	@Test
	public void shouldTestKnightMakeMoveToDown() {

		Knight knight = new Knight(ColorPiece.WHITE);

		board.addPieceToField(3, 4, knight);
		board.makeMove(board, 3, 4, 4, 2, knight);
		Assert.assertTrue(board.getFieldStatus(4, 2));

	}

	@Test
	public void shouldTestKingMakeMoveToLeft() {

		King king = new King(ColorPiece.BLACK);

		board.addPieceToField(3, 4, king);
		board.makeMove(board, 3, 4, 2, 5, king);
		Assert.assertFalse(board.getFieldStatus(3, 4));
		Assert.assertTrue(board.getFieldStatus(2, 5));

	}

	@Test
	public void shouldTestKingMakeMoveToRight() {

		King king = new King(ColorPiece.BLACK);

		board.addPieceToField(3, 4, king);
		board.makeMove(board, 3, 4, 4, 4, king);
		Assert.assertFalse(board.getFieldStatus(3, 4));
		Assert.assertTrue(board.getFieldStatus(4, 4));

	}

	@Test
	public void shouldTestKingMakeMoveToDown() {

		King king = new King(ColorPiece.BLACK);

		board.addPieceToField(6, 2, king);
		board.makeMove(board, 6, 2, 6, 1, king);
		Assert.assertFalse(board.getFieldStatus(6, 2));
		Assert.assertTrue(board.getFieldStatus(6, 1));

	}

	@Test
	public void shouldTestKingMakeMoveIsUnpossible() {

		King king = new King(ColorPiece.BLACK);

		board.addPieceToField(6, 2, king);
		board.makeMove(board, 6, 2, 2, 5, king);
		Assert.assertTrue(board.getFieldStatus(6, 2));
		Assert.assertFalse(board.getFieldStatus(2, 5));

	}
}
