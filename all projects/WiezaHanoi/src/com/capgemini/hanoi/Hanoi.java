package com.capgemini.hanoi;

import java.awt.SecondaryLoop;
import java.util.Scanner;
import java.util.Stack;

public class Hanoi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Podaj ilośc krażków: ");
		while (!sc.hasNextInt()) {
			System.out.println("Wprowadz poprawną liczbę!");
			System.out.println();
			System.out.println("Podaj ilośc krażków: ");
			sc.next();
		}

		int iloscKrazkow = sc.nextInt();

		Stack<Integer> firstStack = new Stack<>();
		Stack<Integer> secondStack = new Stack<>();
		Stack<Integer> thirdStack = new Stack<>();

		for (int i = iloscKrazkow; i > 0; i--) {
			firstStack.push(i);
		}

		System.out.println();
		System.out.println("Pierwszy palik ma elementów: " + firstStack.size() + " " + firstStack);
		System.out.println("Drugi palik ma elementów: " + secondStack.size() + " " + secondStack);
		System.out.println("Trzeci palik ma elementów: " + thirdStack.size() + " " + thirdStack);
		System.out.println();

		popPush(firstStack, secondStack, thirdStack);

		System.out.println("Brawo! wygrales :)");

	}

	public static void popPush(Stack<Integer> firstStack, Stack<Integer> secondStack, Stack<Integer> thirdStack) {

		Scanner sc = new Scanner(System.in);

		Integer temp = 0;
		do {
			isWin(firstStack, secondStack, thirdStack);

			System.out.println("z którego palika pobrać krążek? ");

			while (!sc.hasNextInt()) {
				System.out.println("Wprowadz poprawną liczbę!");
				System.out.println();
				System.out.println("z którego palika pobrać krążek? ");
				sc.next();
			}

			int pipePop = sc.nextInt();

			switch (pipePop) {
			case 1:
				if (firstStack.size() != 0) {
					temp = firstStack.pop();
					break;
				} else
					System.out.println("palik jest pusty");
				System.out.println();
				continue;
			case 2:
				if (secondStack.size() != 0) {
					temp = secondStack.pop();
					break;
				} else
					System.out.println("palik jest pusty");
				System.out.println();
				continue;
			case 3:
				if (thirdStack.size() != 0) {
					temp = thirdStack.pop();
					break;
				} else
					System.out.println("palik jest pusty");
				System.out.println();
				continue;

			default:
				System.out.println("błędna liczba");
			}

			System.out.println("na kóry palik położyć krążek? ");

			while (!sc.hasNextInt()) {
				System.out.println("Wprowadz poprawną liczbę!");
				System.out.println();
				System.out.println("na kóry palik położyć krążek? ");
				sc.next();
			}

			int pipePush = sc.nextInt();

			switch (pipePush) {
			case 1:
				if (firstStack.size() == 0) {
					firstStack.push(temp);
					break;
				} else if (firstStack.peek() > temp) {
					firstStack.push(temp);
					break;
				} else
					System.out.println();
				System.out.println();
				System.out.println("Mozna umieszcac tylko mniejszy krazek na wiekszym!!!");
				if (pipePop == 1) {
					firstStack.push(temp);
				} else if (pipePop == 2) {
					secondStack.push(temp);
				} else
					thirdStack.push(temp);
				break;

			case 2:

				if (secondStack.size() == 0) {
					secondStack.push(temp);
					break;
				} else if (secondStack.peek() > temp) {
					secondStack.push(temp);
					break;
				} else
					System.out.println();
				System.out.println();
				System.out.println("Mozna umieszcac tylko mniejszy krazek na wiekszym!!!");
				if (pipePop == 1) {
					firstStack.push(temp);
				} else if (pipePop == 2) {
					secondStack.push(temp);
				} else
					thirdStack.push(temp);
				break;

			case 3:

				if (thirdStack.size() == 0) {
					thirdStack.push(temp);
					break;
				} else if (thirdStack.peek() > temp) {
					thirdStack.push(temp);
					break;
				} else
					System.out.println();
				System.out.println();
				System.out.println("Mozna umieszcac tylko mniejszy krazek na wiekszym!!!");
				if (pipePop == 1) {
					firstStack.push(temp);
				} else if (pipePop == 2) {
					secondStack.push(temp);
				} else
					thirdStack.push(temp);
				break;

			default:
				System.out.println("błędna liczba");
			}

			System.out.println();
			System.out.println("Pierwszy palik ma elementów: " + firstStack.size() + " " + firstStack);
			System.out.println("Drugi palik ma elementów: " + secondStack.size() + " " + secondStack);
			System.out.println("Trzeci palik ma elementów: " + thirdStack.size() + " " + thirdStack);
			System.out.println();

		} while

		(isWin(firstStack, secondStack, thirdStack) == false);
	}

	public static boolean isWin(Stack<Integer> firstStack, Stack<Integer> secondStack, Stack<Integer> thirdStack) {
		if (firstStack.size() == 0 && secondStack.size() == 0 || firstStack.size() == 0 && thirdStack.size() == 0) {

			return true;
		} else {
			return false;
		}

	}

	public static boolean stackIsEmpty(Stack<Integer> firstStack) {
		if (firstStack.size() == 0) {

			return true;
		} else {
			return false;
		}

	}

	public static boolean move(Stack<Integer> firstStack, Stack<Integer> secondStack) {

		if (firstStack.peek() < secondStack.peek()) {

			return true;

		} else {
			return false;
		}

	}
}
