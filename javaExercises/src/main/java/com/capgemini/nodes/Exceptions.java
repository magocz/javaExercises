package com.capgemini.nodes;

import java.util.LinkedList;
import java.util.List;

public class Exceptions extends Exception {
	private static List<Exception> listOfAllExceptions = new LinkedList<Exception>();	

	public static void addExceptiona(Exception nodeIdException) {
		listOfAllExceptions.add(nodeIdException);
	}

	public static void throwAllExceptions() throws Exception {
		String message = new String();
		for (Exception e : listOfAllExceptions) {
			message += e.getMessage() + "\n";
		}
		System.out.println(message);
		listOfAllExceptions.clear();
	}
}