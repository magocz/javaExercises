package GoL;


import org.junit.Assert;
import org.junit.Test;

public class GoLTest {

	@Test
	public void isAliveShouldBeDead_ForNoNeighbor() {

		Boolean[][] testTab = { { false, false, false }, { false, true, false }, { false, false, false } };

		Game g = new Game(testTab);
		g.displayMap();
		g.iterateMap();
		g.displayMap();

		Assert.assertEquals(false, g.getCellInfo(new Id(1, 1)));

	}

	@Test
	public void isAliveShouldBeDead_ForOneNeighbor() {

		Boolean[][] testTab = { { false, false, false }, { false, true, false }, { false, false, true } };

		Game g = new Game(testTab);
		g.displayMap();
		g.iterateMap();
		g.displayMap();

		Assert.assertEquals(false, g.getCellInfo(new Id(1, 1)));
	}

	@Test
	public void isAliveShouldBeAlive_ForTwoNeighbor() {

		Boolean[][] testTab = { { true, false, false }, { false, true, false }, { false, false, true } };

		Game g = new Game(testTab);
		g.displayMap();
		g.iterateMap();
		g.displayMap();

		Assert.assertEquals(true, g.getCellInfo(new Id(1, 1)));

	}

	@Test
	public void isAliveShouldBeAlive_ForThreeNeighbor() {

		Boolean[][] testTab = { { true, true, false }, { false, true, false }, { false, false, true } };

		Game g = new Game(testTab);
		g.displayMap();
		g.iterateMap();
		g.displayMap();

		Assert.assertEquals(true, g.getCellInfo(new Id(1, 1)));

	}

	@Test
	public void isAliveShouldBeDead_ForMoreThenThreeNeighbor() {

		Boolean[][] testTab = { { true, true, true }, { true, true, false }, { false, false, true } };

		Game g = new Game(testTab);
		g.displayMap();
		g.iterateMap();
		g.displayMap();

		Assert.assertEquals(false, g.getCellInfo(new Id(1, 1)));

	}

	@Test
	public void isDeadShouldBeAlive_ForThreeNeighbor() {

		Boolean[][] testTab = { { true, false, true }, { false, false, false }, { false, false, true } };

		Game g = new Game(testTab);
		g.displayMap();
		g.iterateMap();
		g.displayMap();

		Assert.assertEquals(true, g.getCellInfo(new Id(1, 1)));

	}
	
	
	@Test
	public void randomtest(){

		Game g = new Game(10, 5);
		g.displayMap();
		g.iterateMap();
		g.displayMap();

		g.iterateMap();
		g.displayMap();

		g.iterateMap();
		g.displayMap();

		g.iterateMap();
		g.displayMap();

	}
	
	

}
