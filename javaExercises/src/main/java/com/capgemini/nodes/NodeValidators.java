package com.capgemini.nodes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li>
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {

	private LinkedList<Node> nodes;

	public void validateMethod(List<Node> nodes)
			throws PenultimateNodeException, GraphCycleException, NodeIdException, NodeDescriptionException {
		this.nodes = (LinkedList<Node>) nodes;
		validateNodes();
		isCycle();
		checkThePenultimateNode();
	}

	private void validateNodes() throws NodeIdException, NodeDescriptionException {
		for (Node node : nodes) {
			node.validateMe();
		}
	}

	private void isCycle() {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getPredecessorId().equals("0000")) {
				return;
			}
		}
		new GraphCycleException();
	} 

	public void checkThePenultimateNode() {
		LinkedList<Node> finalNodeList = new LinkedList<Node>();
		boolean isPredictor = true;
		for (Node node : nodes) {
			isPredictor = true;
			for (Node node2 : nodes) {
				if (node.isMyPredictor(node2)) {
					isPredictor = false;
					break;
				}
			}
			if (isPredictor) {
				finalNodeList.add(node);
				if (finalNodeList.size() > 2) {
					new PenultimateNodeException();
					return;
				}
			}
		}
		if (finalNodeList.size() == 2 && isTheSamePredecessor(finalNodeList)) {
			new PenultimateNodeException();
		}
	}

	private boolean isTheSamePredecessor(LinkedList<Node> finalNodeList) {
		if (finalNodeList.getFirst().getPredecessorId().equals(finalNodeList.getLast().getPredecessorId())) {
			return true;
		}
		return false;
	}
}
