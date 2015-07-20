package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CollectionOfTaxis implements Runnable {

	private List<Taxi> taxisList = new ArrayList<Taxi>();

	public CollectionOfTaxis(int numberOfAllTaxis) {
		for (int i = 0; i < numberOfAllTaxis; i++) {
			Taxi t = new Taxi(i);
			taxisList.add(t);
		}
	}

	public void run() {
		Random rand = new Random();
		int id = 0;
		while (true) {

			id = rand.nextInt(taxisList.size());
			taxisList.get(id).move();
			if (taxisList.get(id).haveIChanged() && taxisList.get(id).isAvailability()) {
				Server.update(taxisList.get(id));
			}

			try {
				TimeUnit.MILLISECONDS.sleep(1);

			} catch (InterruptedException e) {
				System.out.println("Blad podczas usypania watku taksowki: " + id);
			}

		}

	}

	public List<Taxi> getTaxisList() {
		return this.taxisList;
	}

}
