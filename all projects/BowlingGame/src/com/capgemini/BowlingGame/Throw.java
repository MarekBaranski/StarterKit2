package com.capgemini.BowlingGame;
import java.util.Arrays;

public class Throw {

	KnockDownPin[] numberOfThrow = new KnockDownPin[3];

	public Throw() {

		numberOfThrow[0] = new KnockDownPin(0);
		numberOfThrow[1] = new KnockDownPin(0);
		numberOfThrow[2] = new KnockDownPin(0);
	}

	public KnockDownPin[] getNumberOfThrow() {
		return numberOfThrow;
	}

	public void setNumberOfThrow(KnockDownPin[] numberOfThrow) {
		this.numberOfThrow = numberOfThrow;
	}

	@Override
	public String toString() {
		return "Throw [numberOfThrow=" + Arrays.toString(numberOfThrow) + "]";
	}

	public boolean isStrike() {

		if (numberOfThrow[0].getPin() == 10) {

			return true;
		} else
			return false;

	}

	public boolean isSpark() {

		if (((numberOfThrow[0].getPin()) != 10)&&((numberOfThrow[0].getPin()) + (numberOfThrow[1].getPin()) == 10)) {

			return true;
		} else
			return false;

	}

	public int sumRound() {

		int suma = numberOfThrow[0].getPin() + numberOfThrow[1].getPin() + numberOfThrow[2].getPin();

		return suma;
	}

}
