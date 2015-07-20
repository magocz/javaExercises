package com.capgemini.pokerHands;

public enum Card{
	TWO("2",2),
	THREE("3",3),
	FOUR("4",4),	
	FIVE("5",5),	
	SIX("6",6),
	SEVEN("7",7),
	EIGHT("8",8),
	NINE("9",9),
	TEN("T",10),
	JACK("J",11),
	QUEEN("Q",12),
	KING("K",13),
	AS("A",14);
	
	private Integer value ;
	private Integer number;
	private String shortcut;
	Card(String shortcut, Integer value){	
		this.setShortcut(shortcut);
		this.setValue(value);
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getShortcut() {
		return shortcut;
	}
	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}
}