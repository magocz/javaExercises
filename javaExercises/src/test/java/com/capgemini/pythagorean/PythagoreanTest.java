package com.capgemini.pythagorean;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTest {

	@Test
	public void test() {
		Assert.assertEquals(200 * 375 * 425, Pythagorean.findABC());
	}

}
