package com.capgemini.nodes;

public class NodeDescriptionException extends Exception {
    public NodeDescriptionException(String nodeId)
    {
       super("Opis wezla o ID " + nodeId + " jest za dlugi!");
       Exceptions.addExceptiona(this);
    }
}