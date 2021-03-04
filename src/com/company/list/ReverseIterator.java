package com.company.list;

public class ReverseIterator{
    private Node currentNode;

    public ReverseIterator(Node currentNode){
        this.currentNode=currentNode;
    }
    public ReverseIterator(ReverseIterator reversIterator){
        currentNode=reversIterator.currentNode;
    }
    public boolean hasPrevious(){
        return currentNode!=null;
    }

    public int previous(){
        int data=currentNode.getData();
        currentNode = currentNode.getPrevious();
        return data;
    }

    Node getCurrentNode() {
        return currentNode;
    }
}
