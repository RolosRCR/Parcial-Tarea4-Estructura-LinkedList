package com.company.list;

 class Node {
    private int data;
    private Node previous;//se inicializan a null sin que yo lo tenga que decir
    private Node next;
    Node(int data){
        this.data=data;
    }
    public int getData() {
        return data;
    }

    public void setData(int dato) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
