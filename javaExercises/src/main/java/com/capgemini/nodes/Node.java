package com.capgemini.nodes;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node {
	private String id;
	private String predecessorId;
	private String description;

	Node(String id, String predecessorId, String description) {
		this.setId(id);
		this.setPredecessorId(predecessorId);
		this.setDescription(description);
	}

	public void validateMe() throws NodeIdException, NodeDescriptionException {
		if (this.getId().length() != 4) {
			new NodeIdException(this.getId());
		}
		if (getDescription().length() > 128) {
			new NodeDescriptionException(this.getId());
		}
	}
	
	public boolean isMyPredictor(Node node) {
		if(getId().equals(node.getPredecessorId())){
			return true;
		}
		return false;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPredecessorId() {
		return predecessorId;
	}

	public void setPredecessorId(String predecessorId) {
		this.predecessorId = predecessorId;
	}

}
