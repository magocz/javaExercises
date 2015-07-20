package com.capgemini.pokerHands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokerTests {

	private Game g;

	@Before
	public void makePokerHands() {
		this.g = new Game();
	}

	@Test
	public void shoudlBeRoyalFlush() {
		Assert.assertEquals(true, g.createGame("AD KD QD JD TD KD QD JD TD 9D"));
	}

	@Test
	public void shoudlBeWinnerStraightFlush() {
		Assert.assertEquals(true, g.createGame("KD QD JD TD 9D TD JS JC JD JH"));
	}

	@Test
	public void shoudlBeLoserStraightFlush() {
		Assert.assertEquals(false, g.createGame("KD QD JD TD 9D AD KD QD JD TD"));
	}

	@Test
	public void shoudlBeWinnerFour() {
		Assert.assertEquals(true, g.createGame("KS KH KD KC 9D TD JS JC JD JH"));
	}

	@Test
	public void shoudlBeWinnerFlus() {
		Assert.assertEquals(true, g.createGame("KS JS 2S AS 9S 9D JS QC JD JH"));
	}

	@Test
	public void shoudlBeLoserFlus() {
		Assert.assertEquals(false, g.createGame("KS JS 2S AS 9S 9D JS JC JD JH"));
	}

	@Test
	public void shoudlBeWinnerStraight() {
		Assert.assertEquals(true, g.createGame("KD QS JD TD 9D KS KH KD QD JH"));
	}

	@Test
	public void shoudlBeLoserStraight() {
		Assert.assertEquals(false, g.createGame("6D 5S 4D 3D 2D KS JS 2S AS 9S"));
	}

	@Test
	public void shoudlBeWinnerThree() {
		Assert.assertEquals(true, g.createGame("KD KS KH TD 9D JS JH KC QD TH"));
	}

	@Test
	public void shoudlBeLoserThree() {
		Assert.assertEquals(false, g.createGame("2D 2S 2H 3D 5D 6D 5S 4D 3D 2D"));
	}

	@Test
	public void shoudlBeWinnerTwoPair() {
		Assert.assertEquals(true, g.createGame("KD KS JH JD 9D QS QH KC TD TH"));
	}

	@Test
	public void shoudlBeLoserTwoPair() {
		Assert.assertEquals(false, g.createGame("2D 2S 3H 3D 5D 7D 7S 7H 8D 9D"));
	}

	@Test
	public void shoudlBeWinnerPair() {
		Assert.assertEquals(true, g.createGame("KD KS TH JD 9D QS 9H KC TD 2H"));
	}

	@Test
	public void shoudlBeLoserPair() {
		Assert.assertEquals(false, g.createGame("2D 2S 3H 8D 5D 2D 2S 3H 3D 5D"));
	}

	@Test
	public void shoudlBeWinnerStraightFlush2() {
		Assert.assertEquals(true, g.createGame("KD QD JD TD 9D AH 2H 3H 4H 5H"));
	}

	@Test
	public void shoudlBeWinnerTwoPair2() {
		Assert.assertEquals(true, g.createGame("KD KS JD JS 9D KD KS JD JS 8D"));
	}

	@Test
	public void shoudlBeWinnerPair2() {
		Assert.assertEquals(true, g.createGame("KD KS JD QS TD KD KS JD QS 8D"));
	}

	@Test
	public void shoudlBeWinnerHightCard2() {
		Assert.assertEquals(true, g.createGame("AD KS JD QS 9D AD KS JD QS 7D"));
	}

}
