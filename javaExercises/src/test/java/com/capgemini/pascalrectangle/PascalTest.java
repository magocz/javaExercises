package com.capgemini.pascalrectangle;


import org.junit.Assert;
import org.junit.Test;



public class PascalTest {

	@Test
	public void soudlBe1For0_0() {
		Assert.assertEquals(0, PascalRectangle.pascal(0, 0));
	}
	
	@Test
	public void soudlBe1For1_1() {
		Assert.assertEquals(1, PascalRectangle.pascal(1, 1));
	}
	
	@Test
	public void soudlBe3For1_3() {
		Assert.assertEquals(3, PascalRectangle.pascal(1, 3));
	}
	
	@Test
	public void soudlBe4For2_5() {
		Assert.assertEquals(10, PascalRectangle.pascal(2, 5));
	}
	
	@Test
	public void soudlBe4For5_2() {
		Assert.assertEquals(10, PascalRectangle.pascal(5, 2));
	}

	
	@Test
	public void soudlBe36For9_3() {
		Assert.assertEquals(84, PascalRectangle.pascal(3, 9));
	}	

}
