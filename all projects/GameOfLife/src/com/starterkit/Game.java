package com.starterkit;

public class Game {

	private static int[][] area;
	private int sizeX = 0;
	private int sizeY = 0;

	public void gameStart(int width, int height) {
		sizeX = width;
		sizeY = height;

		area = new int[width][height];
	}

	public int getArea(int x, int y) {
		return area[x][y];
	}

	public void setCellLife(int x, int y) {

		area[x][y] = 1;
	}

	public void setCelldDeath(int x, int y) {

		area[x][y] = 0;
	}

	public void testOfDeath() {

		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {

				if (area[i][j] == 1) {

					area[i][i] = 0;
				}

			}
		}

	}

	public void testOfLife(int x, int y) {
		int licznik = 0;

		for (int i = -1; i <= 1; i++) {

			x = (x >= (sizeX - 1)) ? x : x + 1;
			x = (x < 0) ? x : 0;

			for (int j = -1; j <= 1; j++) {
				y = (y >= (sizeY - 1)) ? y : y + 1;
				y = (y < 0) ? y : 0;

				if (area[x][y] == 1) {

					licznik++;

				}

			}
		}

		if (area[x][y] == 1)

		{

			licznik--;
		} else if (licznik == 2 || licznik == 3)

		{
			area[x][y] = 1;
		}

		else if (licznik > 3) {

			area[x][y] = 0;
		}

	}

}
