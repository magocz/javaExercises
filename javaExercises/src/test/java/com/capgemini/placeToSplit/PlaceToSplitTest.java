package com.capgemini.placeToSplit;

import org.junit.Assert;
import org.junit.Test;

public class PlaceToSplitTest {

	@Test
	public void shoudlBeTRUEFor2_2() {
		int[] tab = {2,2};
		Assert.assertEquals(true, PlaceToSplit.canBalance(tab));
	}
	
	@Test
	public void shoudlBeFALSEFor2_10() {
		int[] tab = {2,10};
		Assert.assertEquals(false, PlaceToSplit.canBalance(tab));
	}
	
	@Test
	public void shoudlBeTRUEFor1_1_1_2_1() {
		int[] tab = {1, 1, 1, 2, 1};
		Assert.assertEquals(true, PlaceToSplit.canBalance(tab));
	}
	
	
	@Test
	public void shoudlBeFALSEFor2_1_1_2_1() {
		int[] tab = {2, 1, 1, 2, 1};
		Assert.assertEquals(false, PlaceToSplit.canBalance(tab));
	}
	
	@Test
	public void shoudlBeFALSEForMinus2_1_1Plus2() {
		int[] tab = {-2, -1, -1, 2};
		Assert.assertEquals(false, PlaceToSplit.canBalance(tab));
	}
	
	
	@Test
	public void shoudlBeTRUEForMinus2_1_Plus_1_2() {
		int[] tab = {-2, -1, 1, 2};
		Assert.assertEquals(true, PlaceToSplit.canBalance(tab));
	}
	
	
	@Test
	public void shoudlBeTRUEForMinus() {
		int[] tab = {-2, 2, -1, -1, -2};
		Assert.assertEquals(true, PlaceToSplit.canBalance(tab));
	}
	
	

}
