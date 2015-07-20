package com.capgemini.taxi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class User {
	private Integer id = null;
	private Integer x = null;
	private Integer y = null;
	private Integer maxRadius = null;
	private Integer numberOfTaxi = null;

	private DefaultTableModel taxiTabModel;

	public User(int x, int y, int maxRadius, int numberOfTaxi) {
		this.x = x;
		this.y = y;
		this.maxRadius = maxRadius;
		this.numberOfTaxi = numberOfTaxi;
	}

	public void updateTaxiLable(List<Taxi> taxiList) {
	
		Collections.sort(taxiList, new Comp());
		int numberOfAddedTaxis = 0;
		for (Taxi taxi : taxiList) {
			if (numberOfAddedTaxis < this.numberOfTaxi && isCloseEnough(taxi)) {				
				if (taxiTabModel.getRowCount() <= numberOfAddedTaxis) {
					addNewRowToTaxiTable(numberOfAddedTaxis, taxi);
					numberOfAddedTaxis++;
					continue;
				}
				if (taxiTabModel.getRowCount() > numberOfAddedTaxis) {
					fillTaxiTableRow(numberOfAddedTaxis, taxi);
					numberOfAddedTaxis++;
					continue;
				}				
			}			
			break;		
		}
		
		removEmptyRows(numberOfAddedTaxis);
	}

	private void addNewRowToTaxiTable(int index, Taxi taxi) {
		Object[] tmp = { (index + 1), taxi.getId(), taxi.getNew_xCoordinate(), taxi.getNew_yCoordinate(),
				getNewDistance(taxi) };
		this.taxiTabModel.addRow(tmp);
	}

	private void fillTaxiTableRow(int index, Taxi taxi) {
		taxiTabModel.setValueAt(index + 1, index, 0);
		taxiTabModel.setValueAt(taxi.getId(), index, 1);
		taxiTabModel.setValueAt(taxi.getNew_xCoordinate(), index, 2);
		taxiTabModel.setValueAt(taxi.getNew_yCoordinate(), index, 3);
		taxiTabModel.setValueAt(getNewDistance(taxi), index, 4);
	}
	
	private void removEmptyRows(int index){		
		for( int i = this.taxiTabModel.getRowCount() - 1 ; i > index-1; i--){
			this.taxiTabModel.removeRow(i);
		}
	}

	public boolean isCloseEnough(Taxi t) {
		if (getNewDistance(t) <= this.maxRadius) {
			return true;
		}
		return false;
	}

	public int getOldDistance(Taxi T) {
		return (int) Math
				.round(Math.sqrt(Math.pow(this.x - T.getxCoordinate(), 2) + Math.pow(this.y - T.getyCoordinate(), 2)));
	}

	public int getNewDistance(Taxi T) {
		return (int) Math.round(
				Math.sqrt(Math.pow(this.x - T.getNew_xCoordinate(), 2) + Math.pow(this.y - T.getNew_yCoordinate(), 2)));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTaxiTabModel(DefaultTableModel taxiTabModel) {
		this.taxiTabModel = taxiTabModel;
	}

	public Integer getMaxRadius() {
		return maxRadius;
	}	

	private class Comp implements Comparator<Taxi> {
		public int compare(Taxi T1, Taxi T2) {
			if (getNewDistance(T1) > getNewDistance(T2)) {
				return 1;
			}
			if (getNewDistance(T1) < getNewDistance(T2)) {
				return -1;
			}
			return 0;
		}
	}

	public void updateUserData(int x, int y, int maxRadius, int numberOfTaxi) {
		this.x = x;
		this.y = y;
		this.maxRadius = maxRadius;
		this.numberOfTaxi = numberOfTaxi;
		findTaxisInMyPosition();

	}

	private void findTaxisInMyPosition() {	
		Server.update(this);		
	}

}
