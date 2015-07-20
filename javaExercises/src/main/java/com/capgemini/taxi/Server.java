package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private static List<User> usersList = new ArrayList<User>();
	private static List<Taxi> taxiList = new ArrayList<Taxi>();

	static final Integer NUMBER_OF_ALL_TAXIS = 1000;

	public static void main(String[] args) {
		new Server(NUMBER_OF_ALL_TAXIS);
	}

	public Server(int allTaxiNumber) {
		CollectionOfTaxis cOT = new CollectionOfTaxis(allTaxiNumber);
		taxiList = cOT.getTaxisList();
		Thread t = new Thread(cOT);
		t.start();

		UserGui.createGui(null);

	}

	public static void update(Taxi t) {
		ArrayList<User> tmpUsersList = new ArrayList<User>(usersList);
		for (User user : tmpUsersList) {
			if (user.getNewDistance(t) <= user.getMaxRadius()) {				
				user.updateTaxiLable(getAvilableTaxis(user));
			}
		}
	}

	private static ArrayList<Taxi> getAvilableTaxis(User u) {
		ArrayList<Taxi> avilableTaxis = new ArrayList<Taxi>();
		ArrayList<Taxi> tmpTaxiList = new ArrayList<Taxi>(taxiList);
		for (Taxi t : tmpTaxiList) {
			if (t.isAvailability() && (u.isCloseEnough(t) || u.getOldDistance(t) <= u.getMaxRadius())) {
				avilableTaxis.add(t);
			}
		}
		return avilableTaxis;
	}

	public static void addUser(User u) {		
		u.setId(usersList.size());
		usersList.add(u);
		update(u);		
		System.out.println("Dodano uzytkownika!");
	}

	public static void update(User user) {		;
		user.updateTaxiLable(getAvilableTaxis(user));
	}

}
