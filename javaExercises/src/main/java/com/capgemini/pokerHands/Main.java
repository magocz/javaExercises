package com.capgemini.pokerHands;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Game g = new Game();
		g.getDataFromFile(
				"C:/Users/magocz/Documents/capgemini/pierwszeZadanie/javaExercises/src/main/resources/poker.txt");
		System.out.println("Gracz pierwszy wygrywa: " + g.countLeftHandWin());

	}

}
