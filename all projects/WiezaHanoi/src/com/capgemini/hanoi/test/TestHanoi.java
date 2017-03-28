package com.capgemini.hanoi.test;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.hanoi.Hanoi;


public class TestHanoi {

	
	
	Stack<Integer> firstStack = new Stack<>();
	Stack<Integer> secondStack = new Stack<>();
	Stack<Integer> thirdStack = new Stack<>();

	@Test
	public void shouldBeFalseWhenStackIsNoEmpty() {
		// given
		firstStack.push(1);
		// when
		boolean trueFalse = Hanoi.stackIsEmpty(firstStack);
		// then
		Assert.assertFalse("Stos jest pełny", trueFalse);

	}

	@Test
	public void shouldBetrueWhenStackIsEmpty() {
		// given		
		// when
		boolean trueFalse = Hanoi.stackIsEmpty(firstStack);
		// then
		Assert.assertTrue("Stos jest pełny", trueFalse);

	}

	@Test
	public void shouldBetrueWhenMoveFromStackFirstToSecondIsPossible() {
		// given
		firstStack.push(1);
		secondStack.push(2);
		
		// when
		boolean trueFalse = Hanoi.move(firstStack,secondStack);
		// then
		Assert.assertTrue("tak, mozna wykonac ruch", trueFalse);

	}

}
