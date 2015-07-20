package com.capgemini.nodes;

public class PenultimateNodeException extends Exception {
	public PenultimateNodeException() {
		super("Przed ostatni wezel posiada wiecej niz dwoch poprzednikow!");
		Exceptions.addExceptiona(this);
	}
}