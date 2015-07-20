package com.capgemini.fibonacci;


import org.junit.Assert;
import org.junit.Test;



public class FibonaciTest {
	
	@Test
	public void shoudlBe1For1() {
		Assert.assertEquals(1, Fibonacci.fib(1));
	}
	
	@Test
	public void shoudlBe0For0() {
		Assert.assertEquals(0, Fibonacci.fib(0));
	}

	@Test
	public void shoudlBe21For8() {
		Assert.assertEquals(21, Fibonacci.fib(8));
	}	
	
	@Test
	public void shoudlBeMinusOneForMinusOne() {
		Assert.assertEquals(0, Fibonacci.fib(-1));
	}
	
	@Test
	public void shoudlBe55For10() {
		Assert.assertEquals(55, Fibonacci.fib(10));
	}

}
