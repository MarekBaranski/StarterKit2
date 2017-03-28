package com.capgemini.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println(fib(5));

		System.out.println("Najwięszy long: " + maxValue());

	}

	public static boolean isInRange(int n) {

		if (n <= 92) {
			return true;
		}

		return false;
	}

	public static long fib(int n) {

		long temp1 = 1;
		long temp2 = 1;
		long fib = 1;

		if (n < 0) {

			throw new IllegalArgumentException("liczba mniejsza od zera");
		}


		
	
		for (int i = 2; i < n; i++) {
			fib = temp1 + temp2;
			temp1 = temp2;
			temp2 = fib;
		}

		return fib;
	}
	

	public static long maxValue() {
		long temp = Long.MAX_VALUE;
		long max = 0;
		for (int i = 0; i < temp; i++) {

			if (fib(i) < 0) {

				max = fib(i - 1);
				System.out.println("Ostatnia wartośc nie przekraczająca zakresu long " +( i - 1));
				break;

			} else
				continue;

		}
		return max;
	}

}
