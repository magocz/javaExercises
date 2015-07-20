package GoL;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private boolean isAlive;
	private boolean nextStage;
	private List<Cell> neighborList;
	private Id id;

	public Cell(int x, int y, boolean isAlive) {
		this.setId(new Id(x, y));
		this.isAlive = isAlive;
		this.neighborList = new ArrayList<Cell>();
	}

	public void addNeihbor(Cell c) {
		this.neighborList.add(c);
	}

	public void setMyNextState() {

		int numberOfAliveNeighbors = countAliveNeighbor();

		if (numberOfAliveNeighbors < 2 && this.isAlive == true) {
			this.nextStage = false;
		}
		if ((numberOfAliveNeighbors == 2 || numberOfAliveNeighbors == 3) && this.isAlive == true) {
			this.nextStage = true;
		}
		if (numberOfAliveNeighbors > 3 && this.isAlive == true) {
			this.nextStage = false;
		}
		if (numberOfAliveNeighbors == 3 && this.isAlive == false) {
			this.nextStage = true;
		}
	}

	public int countAliveNeighbor() {
		int numberOfAliveCells = 0;
		for (Cell c : this.neighborList) {
			if (c.isAlive() == true) {
				numberOfAliveCells++;
			}
		}
		return numberOfAliveCells;
	}

	public void setMyStage() {
		this.isAlive = this.nextStage;
	}

	// geters and seters
	public boolean isAlive() {
		return isAlive;
	}

	public List<Cell> getNeighborList() {
		return neighborList;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

}
