package GoL;

import java.util.HashMap;
import java.util.Map;

public class Game {

	private Map<Id, Cell> cellMap = new HashMap<Id, Cell>();
	private Integer x = 0; // rozmary mapy
	private Integer y = 0;

	public Game(int x, int y) {
		this.y = y;
		this.x = x;
		for (y = 0; y < this.y; y++) {
			for (x = 0; x < this.x; x++) {
				Cell c = new Cell(x, y, randStage());
				this.addCellToMap(c);
			}
		}

		fillNeighborList();
	}

	private boolean randStage() {
		return Math.random() < 0.5;
	}

	public Game(Boolean[][] cellTab) {
		this.y = cellTab.length;
		this.x = cellTab[0].length;
		for (int y = 0; y < this.y; y++) {
			for (int x = 0; x < this.x; x++) {
				Cell c = new Cell(x, y, cellTab[y][x]);
				this.addCellToMap(c);
			}
		}

		fillNeighborList();
	}

	private void addCellToMap(Cell c) {
		cellMap.put(c.getId(), c);
	}

	public void iterateMap() {
		findNextStage();
		setNextStage();
	}

	// uzupelni liste sasiadow wszystkich komorek
	public void fillNeighborList() {
		for (Map.Entry<Id, Cell> entry : cellMap.entrySet()) {
			setNeighborList(entry.getValue());
		}
	}

	// uzupelni liste sasiadow danej komorki
	public void setNeighborList(Cell c) {
		Id id = null;
		for (int x = c.getId().getX() - 1; x <= c.getId().getX() + 1; x++) {
			for (int y = c.getId().getY() - 1; y <= c.getId().getY() + 1; y++) {
				id = new Id(x, y);
				if (!c.getId().equals(id) && cellMap.containsKey(id)) {
					c.addNeihbor(cellMap.get(id));
				}
			}
		}
	}

	// znajdz nastepny stan
	public void findNextStage() {
		for (Map.Entry<Id, Cell> entry : cellMap.entrySet()) {
			entry.getValue().setMyNextState();
		}
	}

	// przypisz do terazniejszego stanu, stan nastepnu
	public void setNextStage() {
		for (Map.Entry<Id, Cell> entry : cellMap.entrySet()) {
			entry.getValue().setMyStage();
		}
	}

	public void displayMap() {
		System.out.println("Swiat: ");
		for (int y = 0; y < this.y; y++) {
			System.out.print("|");
			for (int x = 0; x < this.x; x++) {
				if (getCellInfo(new Id(x, y))) {
					System.out.print("*|");
					continue;
				}
				System.out.print(" |");
			}
			System.out.println("");
		}

		System.out.println("");
	}

	public boolean getCellInfo(Id id) {
		return cellMap.get(id).isAlive();
	}

	public Cell getCell(Id id) {
		return cellMap.get(id);
	}
}
