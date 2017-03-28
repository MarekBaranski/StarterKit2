package com.capgemini.fibonacci.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.capgemini.fibonacci.Fibonacci;

public class FibonacciTest {

	@Test
	public void sholudGiveOneWhenAisZero() {
		// given
		int a = 0;

		new Fibonacci();
		// when
		long result = new Fibonacci().fib(a);

		// then
		assertEquals(1, result);
	}

	@Test
	public void sholudGive21WhenAisEight() {
		// given
		int a = 8;

		new Fibonacci();
		// when
		long result = new Fibonacci().fib(a);

		// then
		assertEquals(21, result);
	}

	@Test
	(expected = IllegalArgumentException.class)

	public void shouldThrownIllegalArgumentExceptionOnWrongParameters() {

		new Fibonacci().fib(-1);

	}

	@Test
	public void sholudGiveLongInRangeWhenAis92() {
		// given
		int a = 92;

		new Fibonacci();
		// when
		long result = new Fibonacci().fib(a);

		// then
		assertEquals(7540113804746346429L, result);
	}

	// metoda sprawdzająca czy n mieści się w przedziale 0 do 92 zeby nie
	// przekroczylo longa

	

	

	@Test

	public void sholudGiveTrueWhenFibIsInRangeLong() {

		boolean trueFalse = new Fibonacci().isInRange(8);

		assertTrue("Mieści się w zakresie long", trueFalse);

	}

}
