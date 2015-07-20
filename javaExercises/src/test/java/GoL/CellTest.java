package GoL;



import org.junit.Assert;
import org.junit.Test;

public class CellTest {

	@Test
	public void	shouldHaveThreeNeighborFor_0_0() {
		
		Boolean[][] testTab = { {false , false, false} , { false , true, false} , { false , false, false}};
		
		Game g = new Game(testTab);		
		
		Assert.assertEquals(3, g.getCell(new Id(0,0)).getNeighborList().size());
		
	}
	
	@Test
	public void	shouldHaveFiveNeighborFor_0_1() {
		
		Boolean[][] testTab = { {false , false, false} , { false , true, false} , { false , false, false}};
		
		Game g = new Game(testTab);		
		
		Assert.assertEquals(5, g.getCell(new Id(1,0)).getNeighborList().size());
		
	}
	
	@Test
	public void	shouldHaveEightNeighborFor_1_1() {
		
		Boolean[][] testTab = { {false , false, false} , { false , true, false} , { false , false, false}};
		
		Game g = new Game(testTab);		
		
		Assert.assertEquals(8, g.getCell(new Id(1,1)).getNeighborList().size());
		
	}
	
	@Test
	public void	shouldHaveTwoAliveNeighborFor_0_0() {
		
		Boolean[][] testTab = { {true , true, false} , { false , true, false} , { true , false, false}};
		
		Game g = new Game(testTab);		
		
		Assert.assertEquals(2, g.getCell(new Id(0,0)).countAliveNeighbor());
		
	}
	
	@Test
	public void	shouldHaveTwoAliveNeighborFor_0_1() {
		
		Boolean[][] testTab = { {true , false, false} , { false , true, false} , { true , false, false}};
		
		Game g = new Game(testTab);	
		
		Assert.assertEquals(2, g.getCell(new Id(1,0)).countAliveNeighbor());
		
	}
	
	
	@Test
	public void	shouldHaveThreAliveNeighborFor_1_1() {
		
		Boolean[][] testTab = { {true , false, false} , { false , true, false} , { true , false, true}};
		
		Game g = new Game(testTab);		
		
		Assert.assertEquals(3, g.getCell(new Id(1,1)).countAliveNeighbor());
		
	}
	
}
