package com.capgemini.pokerHands;

public enum CardSystem {
	HIGH_CARD(1), ONE_PAIR(2), TWO_PAIR(3), THREE_OF_A_KING(4),
	STRAIGHT(5), FLUSH(6), FULL_HOUSE(7), QUADS(8), STRAIGHT_FLUSH(9),
	ROYAL_FLUSH(10);
	
	private Integer value;
	
	private CardSystem(Integer value) {
		this.setValue(value);
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
