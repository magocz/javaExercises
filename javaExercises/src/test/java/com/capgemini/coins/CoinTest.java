package com.capgemini.coins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinTest {
	List<Integer> coins;

	@Before
	public void createList() {
		coins = new ArrayList<Integer>();
	}

	@Test
	public void shoudlBe0For_1_1() {
		Integer tmp[] = { 1, 1 };
		coins = new ArrayList<Integer>(Arrays.asList(tmp));
		Assert.assertEquals(0, Coins.solution(coins));
	}

	@Test
	public void shoudlBe0For_0_0() {
		Integer tmp[] = { 0, 0 };
		coins = new ArrayList<Integer>(Arrays.asList(tmp));
		Assert.assertEquals(0, Coins.solution(coins));
	}

	@Test
	public void shoudlBe1For_1_0() {
		Integer tmp[] = { 1, 0 };
		coins = new ArrayList<Integer>(Arrays.asList(tmp));
		Assert.assertEquals(1, Coins.solution(coins));
	}

	@Test
	public void shoudlBe1For_0_1() {
		Integer tmp[] = { 0, 1, };
		coins = new ArrayList<Integer>(Arrays.asList(tmp));
		Assert.assertEquals(1, Coins.solution(coins));
	}

	@Test
	public void shoudlBe4For_1_1_0_1_0_0() {
		Integer tmp[] = { 1, 1, 0, 1, 0, 0 };
		coins = new ArrayList<Integer>(Arrays.asList(tmp));
		Assert.assertEquals(4, Coins.solution(coins));
	}

	@Test
	public void shoudlBe4For_0_0_0_0_0_0() {
		Integer tmp[] = { 0, 0, 0, 0, 0, 0 };
		coins = new ArrayList<Integer>(Arrays.asList(tmp));
		Assert.assertEquals(4, Coins.solution(coins));
	}

	@Test
	public void shoudlBe4For_1_1_1_1_1_1() {
		Integer tmp[] = { 1, 1, 1, 1, 1, 1 };
		coins = new ArrayList<Integer>(Arrays.asList(tmp));
		Assert.assertEquals(4, Coins.solution(coins));
	}

	@Test
	public void shoudlBe0For_EmptyList() {
		Assert.assertEquals(0, Coins.solution(coins));
	}

}
