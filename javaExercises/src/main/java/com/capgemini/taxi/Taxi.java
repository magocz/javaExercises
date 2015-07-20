package com.capgemini.taxi;

import java.util.Random;


public class Taxi {
	
	private final Integer MAX_X = 2000;
	private final Integer MAX_Y = 2000;
	
	private Integer id;
	private Integer xCoordinate = 0;
	private Integer yCoordinate = 0;
	private Integer new_xCoordinate = 0;
	private Integer new_yCoordinate = 0;
	

	private boolean availability;	

	public Taxi(int id) {
		this.id = id;
		this.new_xCoordinate = rand_xPosition();
		this.new_yCoordinate = rand_yPosition();
		this.availability = randAvibility();
	}
	
	private int rand_xPosition(){
		Random rand = new Random(); 
		return rand.nextInt(MAX_X) + 1;
	}
	
	private int rand_yPosition(){
		Random rand = new Random();
		return rand.nextInt(MAX_Y) + 1;
	}

	private boolean randAvibility() {
		return new Random().nextBoolean();
	}
	
	public void move(){
		setNewCoordinate();
		setNewState();
	}
	
	private void setNewCoordinate(){
		Random rand = new Random();
		this.xCoordinate = this.new_xCoordinate;
		this.yCoordinate = this.new_yCoordinate;
		this.new_xCoordinate = Math.abs(this.new_xCoordinate += rand.nextInt(200) - 100);
		this.new_yCoordinate = Math.abs(this.new_yCoordinate += rand.nextInt(200) - 100);
		
	}
	
	private void setNewState(){
		Random rand = new Random();
		int tmp = rand.nextInt(20);
		if (tmp == 5) {
			this.availability = false;
		}
		if (tmp == 15) {
			this.availability = true;
		}
	}
	
	public  boolean haveIChanged(){
		if(this.xCoordinate == this.new_xCoordinate && this.yCoordinate == this.new_yCoordinate){
			return false;
		}
		return true;
	}

	public int getId() {
		return id;
	}

	public boolean isAvailability() {
		return availability;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	public Integer getNew_yCoordinate() {
		return new_yCoordinate;
	}

	public void setNew_yCoordinate(Integer new_yCoordinate) {
		this.new_yCoordinate = new_yCoordinate;
	}
	
	public Integer getNew_xCoordinate() {
		return new_xCoordinate;
	}

	public void setNew_xCoordinate(Integer new_xCoordinate) {
		this.new_xCoordinate = new_xCoordinate;
	}
}
