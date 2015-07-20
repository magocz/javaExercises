package com.capgemini.nodes;

public class NodeIdException extends Exception {
    public NodeIdException(String nodeId)
    {
       super("Nie prawidlowa dlugos ID wezla: " + nodeId);
       Exceptions.addExceptiona(this);
    }      
}
