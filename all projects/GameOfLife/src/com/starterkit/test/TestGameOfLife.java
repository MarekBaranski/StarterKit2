package com.starterkit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.starterkit.Game;

public class TestGameOfLife {

	Game game;

	@Before
	public void setUp() {

		game = new Game();
		game.gameStart(5, 5);
	}

	@Test
	public void shouldCreateArea() {
		// given
		// when
		// then
		assertEquals(0, game.getArea(4, 4));
	}

	@Test
	public void shouldCreateLifeCell() {
		// given
		// when
		game.setCellLife(4, 4);
		// then
		assertEquals(1, game.getArea(4, 4));
	}

	@Test
	public void shouldCreateDeathCell() {
		// given
		game.setCellLife(4, 4);
		// when
		game.setCelldDeath(4, 4);
		// then
		assertEquals(0, game.getArea(4, 4));
	}

	@Test
	public void shouldGiveZeroWhenCellIsDeath() {
		// given
		game.setCellLife(4, 4);
		// when
		game.testOfDeath();
		// then
		assertEquals(0, game.getArea(4, 4));
	}

	@Test
	public void shouldGiveOneWhenCellIsLife() {
		// given
		game.setCellLife(4, 2);
		game.setCellLife(4, 3);
		game.setCellLife(4, 1);
		// when
		game.testOfLife(4, 2);
		// then
		assertEquals(1, game.getArea(4, 2));
	}

}
