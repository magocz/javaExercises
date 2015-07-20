package com.capgemini.pokerHands;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hand {
	private Map<Card, Integer> setMap = new HashMap<Card, Integer>();
	private LinkedList<Card> setList = new LinkedList<Card>();
	private LinkedList<Integer> handRank = new LinkedList<Integer>();

	private boolean isFlush;

	public Hand(String cardInHand) {
		isFlush = false;
		checkFlush(cardInHand);
		
		String[] paraseHand = cardInHand.split("");	
		for (String s : paraseHand) {
			addCard(s);
		}
	}	

	private void addCard(String s) {
		for (Card c : Card.values()) {
			if (c.getShortcut().equals(s)) {
				if (setMap.containsKey(c)) {
					int count = setMap.get(c);
					setMap.remove(c);
					c.setNumber(count + 1);
					setMap.put(c, count + 1);
					return ;
				}
				setMap.put(c, 1);
				return ;
			}
		}		
	}
	
	private void checkFlush(String cardInHand){
		cardInHand += " ";
		String[] color = { "S" , "H", "D", "C"};
		for(String c : color){
			if(cardInHand.split(c).length == 6){
				isFlush = true;
				return;
			}
		}
	}

	public List<Integer> validateMy() {
		handRank.clear();
		parseMapToList();
		calculateHandRank();
		return handRank;
	}

	private void parseMapToList() {
		for (Card key : setMap.keySet()) {
			key.setNumber(setMap.get(key));
			setList.add(key);
		}
		sortSetList();
	}

	private void sortSetList() {
		Collections.sort(setList, new CardComper());
	}

	public void calculateHandRank() {
		if (isRoyalPoker() || isStraightFlush() || isFour() || isFullHous() || isFlush() || isStraight() || isThree()
				|| isTwoPair() || isPair() || isHighCard()) {
			return;
		}
	}

	private boolean isRoyalPoker() {
		if (setList.size() == 5 && (setList.getFirst().getValue() - setList.getLast().getValue()) == 4 && isFlush
				&& setList.getFirst().getValue() == 14) {
			handRank.add(CardSystem.ROYAL_FLUSH.getValue());
			return true;
		}
		return false;
	}

	private boolean isStraightFlush() {
		if (setList.size() == 5 && ((setList.getFirst().getValue() - setList.getLast().getValue()) == 4
				|| (setList.getFirst().getValue() - setList.get(1).getValue()) == 9) && isFlush) {
			handRank.add(CardSystem.STRAIGHT_FLUSH.getValue());
			handRank.add(setList.getLast().getValue());
			return true;
		}
		return false;
	}

	private boolean isFour() {
		if (setList.size() == 2 && setList.getLast().getNumber() == 1) {
			handRank.add(CardSystem.QUADS.getValue());
			handRank.add(setList.getFirst().getValue());
			handRank.add(setList.getLast().getValue());
			return true;
		}
		return false;
	}

	private boolean isFullHous() {
		if (setList.size() == 2 && setList.getLast().getNumber() == 2) {
			handRank.add(CardSystem.FULL_HOUSE.getValue());
			handRank.add(setList.getFirst().getValue());
			handRank.add(setList.getLast().getValue());
			return true;
		}
		return false;
	}

	public boolean isFlush() {
		if (isFlush) {
			handRank.add(CardSystem.FLUSH.getValue());
			for (Card c : setList) {
				handRank.add(c.getValue());
			}
			return true;
		}
		return false;
	}

	private boolean isStraight() {
		if (setList.size() == 5 && ((setList.getFirst().getValue() - setList.getLast().getValue()) == 4
				|| (setList.getFirst().getValue() - setList.get(1).getValue()) == 9)) {
			handRank.add(CardSystem.STRAIGHT.getValue());
			handRank.add(setList.getLast().getValue());
			return true;
		}
		return false;
	}

	public boolean isThree() {
		if (setList.size() == 3 && setList.getFirst().getNumber() == 3) {
			handRank.add(CardSystem.THREE_OF_A_KING.getValue());
			for (Card c : setList) {
				handRank.add(c.getValue());
			}
			return true;
		}
		return false;
	}

	public boolean isTwoPair() {
		if (setList.size() == 3 && setList.getFirst().getNumber() == 2) {
			handRank.add(CardSystem.TWO_PAIR.getValue());
			for (Card c : setList) {
				handRank.add(c.getValue());
			}
			return true;
		}
		return false;
	}

	public boolean isPair() {
		if (setList.size() == 4) {
			handRank.add(CardSystem.ONE_PAIR.getValue());
			for (Card c : setList) {
				handRank.add(c.getValue());
			}
			return true;
		}
		return false;
	}

	public boolean isHighCard() {
		if (setList.size() == 5 && (setList.getFirst().getValue() - setList.getLast().getValue()) != 4
				&& (setList.getFirst().getValue() - setList.get(1).getValue()) != 9) {
			handRank.add(CardSystem.HIGH_CARD.getValue());
			for (Card c : setList) {
				handRank.add(c.getValue());
			}
			return true;
		}
		return false;
	}

	private class CardComper implements Comparator<Card> {
		public int compare(Card c1, Card c2) {
			if (c1.getNumber() < c2.getNumber()) {
				return 1;
			}
			if (c1.getNumber() == c2.getNumber() && c1.getValue() < c2.getValue()) {
				return 1;
			}
			return -1;
		}
	}
}
