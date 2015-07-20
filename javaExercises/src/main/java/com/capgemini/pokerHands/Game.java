package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	public List<String> data = new ArrayList<String>();

	public void getDataFromFile(String fileName) throws IOException {

		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		data.clear();
		String textLine = bufferedReader.readLine();

		while (textLine != null) {
			data.add(textLine);
			textLine = bufferedReader.readLine();
		}
		bufferedReader.close();
	}

	public int countLeftHandWin() {
		int count = 0;
		for (String line : data) {
			if (createGame(line)) {
				count++;
			}
		}
		return count;
	}

	public boolean createGame(String line) {

		String lH = line.substring(0, (line.length() / 2));
		lH = lH.replace(" ", "");
		String rH = line.substring((line.length() / 2), line.length());
		rH = rH.replace(" ", "");

		Hand leftHand = new Hand(lH);
		Hand rightHand = new Hand(rH);

		return isLeftHandWinner(leftHand.validateMy(), rightHand.validateMy());

	}

	public boolean isLeftHandWinner(List<Integer> leftHandRank, List<Integer> rightHandRank) {
		for (int i = 0; i < leftHandRank.size(); i++) {
			if (leftHandRank.get(i) == rightHandRank.get(i)) {
				continue;
			}
			if (leftHandRank.get(i) > rightHandRank.get(i)) {
				return true;
			}
			break;
		}

		return false;
	}

}
