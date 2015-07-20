package com.capgemini.nodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GraphTest {

	private List<Node> nodes = new LinkedList<Node>();

	@Before
	public void clearList() {
		nodes.clear();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrowAllExceptions() throws Exception {
		Node nodeTab[] = { new Node("001", "0003", "pierwszy"),
				new Node("0002", "001",
						"drugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugi"),
				new Node("0003", "0002", "trzeci"), new Node("0004", "0003", "czwarty"),
				new Node("0005", "0004", "piaty"), new Node("0006", "0004", "szosty"),
				new Node("0007", "0006", "siodmy"), new Node("0008", "0006", "osmy") };
		nodes = new LinkedList<Node>(Arrays.asList(nodeTab));
		NodeValidators nV = new NodeValidators();
		nV.validateMethod(nodes);
		Exceptions.throwAllExceptions();
	}

	@Test
	public void shouldThrowCycleException() throws Exception {
		Node nodeTab[] = { new Node("0001", "0004", "pierwszy"), new Node("0002", "0001", "drugi"),
				new Node("0003", "0002", "trzeci"), new Node("0004", "0003", "czwarty") };
		nodes = new LinkedList<Node>(Arrays.asList(nodeTab));
		NodeValidators nV = new NodeValidators();
		nV.validateMethod(nodes);
		Exceptions.throwAllExceptions();
	}

	@Test
	public void shouldThrowIDException() throws Exception {
		Node nodeTab[] = { new Node("001", "0000", "pierwszy"), new Node("0002", "001", "drugi"),
				new Node("0003", "0002", "trzeci"), new Node("0004", "0003", "czwarty") };
		nodes = new LinkedList<Node>(Arrays.asList(nodeTab));
		NodeValidators nV = new NodeValidators();
		nV.validateMethod(nodes);
		Exceptions.throwAllExceptions();
	}

	@Test
	public void shouldThrowDescriptionExceptions() throws Exception {
		Node nodeTab[] = { new Node("0001", "0000", "pierwszy"),
				new Node("0002", "001",
						"drugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugidrugi"),
				new Node("0003", "0002", "trzeci") };
		nodes = new LinkedList<Node>(Arrays.asList(nodeTab));
		NodeValidators nV = new NodeValidators();
		nV.validateMethod(nodes);
		Exceptions.throwAllExceptions();
	}

	@Test
	public void shouldThrowPenultimateExceptions() throws Exception {
		Node nodeTab[] = { new Node("0001", "0000", "pierwszy"), new Node("0002", "001", "drugi"),
				new Node("0003", "0002", "trzeci"), new Node("0004", "0002", "czwarty") ,
				new Node("0005", "0002", "piaty") };
		nodes = new LinkedList<Node>(Arrays.asList(nodeTab));
		NodeValidators nV = new NodeValidators();
		nV.validateMethod(nodes);
		Exceptions.throwAllExceptions();
	}

}
