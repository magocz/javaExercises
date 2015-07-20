package com.capgemini.nodes;

public class GraphCycleException extends Exception {
	public GraphCycleException() {
		super("Graf zawiera cykle!");
		Exceptions.addExceptiona(this);
	}
}