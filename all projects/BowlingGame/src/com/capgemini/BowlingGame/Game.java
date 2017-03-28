package com.capgemini.BowlingGame;
import java.time.temporal.IsoFields;

public class Game implements BowlingGameResultCalculator {

	public static void main(String[] args) {

		Game round = new Game();

		while (!round.isFinished()) {
			round.score();
		}

		System.out.println("Koniec gry");

	}

	Throw[] round = new Throw[10];

	int currentRound = 0;

	public Game() {

		for (int i = 0; i < 10; i++) {

			round[i] = new Throw();

		}
		round[0].numberOfThrow[0].setPin(10);
		round[0].numberOfThrow[1].setPin(0);
		round[1].numberOfThrow[0].setPin(9);
		round[1].numberOfThrow[1].setPin(1);
		round[2].numberOfThrow[0].setPin(5);
		round[2].numberOfThrow[1].setPin(5);
		round[3].numberOfThrow[0].setPin(7);
		round[3].numberOfThrow[1].setPin(2);
		round[4].numberOfThrow[0].setPin(10);
		round[4].numberOfThrow[1].setPin(0);
		round[5].numberOfThrow[0].setPin(10);
		round[5].numberOfThrow[1].setPin(0);
		round[6].numberOfThrow[0].setPin(10);
		round[6].numberOfThrow[1].setPin(0);
		round[7].numberOfThrow[0].setPin(9);
		round[7].numberOfThrow[1].setPin(0);
		round[8].numberOfThrow[0].setPin(8);
		round[8].numberOfThrow[1].setPin(2);
		round[9].numberOfThrow[0].setPin(9);
		round[9].numberOfThrow[1].setPin(1);
		round[9].numberOfThrow[2].setPin(10);

		for (int i = 0; i < 10; i++) {

			if (i < 9) {
				System.out.print(
						"Runda " + (i + 1) + " rzut pierwszy: " + round[i].numberOfThrow[0].getPin() + " rzut drugi: ");
				System.out.println(round[i].numberOfThrow[1].getPin());
			}

			else {

				System.out.println(
						("Runda " + (i + 1) + " rzut pierwszy: " + round[i].numberOfThrow[0].getPin() + " rzut drugi: ")
								+ (round[i].numberOfThrow[1].getPin())
								+ (" rzut trzeci: " + round[i].numberOfThrow[2].getPin()));
			}
			// System.out.println("Suma punktów bez premii dla rundy " + (i + 1)
			// + " to: " + round[i].sumRound());
			// System.out.println();
		}

	}

	@Override
	public void roll(int numberOfPins) {

		round[0].numberOfThrow[0].setPin(numberOfPins);

	}

	@Override
	public int score() {
		int sum = 0;
		int bonus = 0;
		int totalScoreOfRound = 0;
		int finishScore = 0;
		// for (int i = 0; i < 10; i++) {
		//
		// sum += round[i].sumRound();
		//
		// }
		// System.out.println("Suma punktów: " + sum);

		for (int i = 0; i < 10; i++) {
			currentRound++;
			if (i == 9) {

				totalScoreOfRound = round[i].sumRound();
				System.out.println("Suma punktów dla rundy " + (i + 1) + " to " + totalScoreOfRound);
				finishScore += totalScoreOfRound;

			} else if ((round[i].isStrike() == true) && (round[i + 1].isStrike() == false)) {
				sum = round[i].sumRound();
				bonus = round[i + 1].sumRound();

				totalScoreOfRound = sum + bonus;
				System.out.println("Suma punktów z premią dla rundy " + (i + 1) + " to " + totalScoreOfRound);
				finishScore += totalScoreOfRound;
			}

			else if (((round[i].isStrike()) == true) && ((round[i + 1].isStrike()) == true)) {
				sum = 20;
				bonus = round[i + 2].numberOfThrow[0].getPin();

				totalScoreOfRound = sum + bonus;
				System.out.println("Suma punktów z premią dla rundy " + (i + 1) + " to " + totalScoreOfRound);
				finishScore += totalScoreOfRound;
			} else if ((round[i].isSpark()) == true) {
				sum = round[i].sumRound();
				bonus = round[i + 1].numberOfThrow[0].getPin();

				totalScoreOfRound = sum + bonus;
				System.out.println("Suma punktów z premią dla rundy " + (i + 1) + " to " + totalScoreOfRound);
				finishScore += totalScoreOfRound;
			} else if (((round[i].isStrike()) == false) && ((round[i + 1].isSpark()) == false)) {

				totalScoreOfRound = round[i].sumRound();
				System.out.println("Suma punktów z premią dla rundy " + (i + 1) + " to " + totalScoreOfRound);
				finishScore += totalScoreOfRound;
			} else {
				totalScoreOfRound = round[i].sumRound();
				System.out.println("Suma punktów z premią dla rundy " + (i + 1) + " to " + totalScoreOfRound);
				finishScore += totalScoreOfRound;

			}

		}
		System.out.println(finishScore);

		return totalScoreOfRound;
	}

	@Override
	public boolean isFinished() {
		if (currentRound == 10)
			return true;
		else
			return false;
	}

}
