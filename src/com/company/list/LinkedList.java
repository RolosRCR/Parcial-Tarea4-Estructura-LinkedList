package com.company.list;
/**
 * Lista doblemente ligada
 */
public class LinkedList<T> {
    private class Node<T> {
        private T data;
        private Node<T> previous;//se inicializan a null sin que yo lo tenga que decir
        private Node<T> next;
        Node(T data){
            this.data=data;
        }
        public T getData() {
            return data;
        }

        public void setData(T dato) {
            this.data = data;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }
    public static final int BEFORE = 0;
    public static  final int AFTER = 1;
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public  class Iterator {
        private Node<T> currentNode;
        public Iterator() {this.currentNode = head; }
        public Iterator(Iterator iterator) {currentNode = iterator.currentNode; }
        public boolean hasNext() { return currentNode != null;}
        public T next() {
            T data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data; }
        Node<T> getCurrentNode() { return currentNode; }}
        public  class ReverseIterator{
        private Node<T> currentNode;
        public ReverseIterator(){
            this.currentNode=tail;
        }
        public ReverseIterator(ReverseIterator reversIterator){
            currentNode=reversIterator.currentNode;
        }
        public boolean hasPrevious(){
            return currentNode!=null;
        }
        public T previous(){
            T data = currentNode.getData();
            currentNode = currentNode.getPrevious();
            return data;
        }
        Node<T> getCurrentNode() {
            return currentNode;
        }
    }
    /**
     * Inserts data at the end of the list
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);
        node.setPrevious(tail);
        if (tail != null) {
            tail.setNext(node);
        }
        if (head == null) {
            head = node;
        }
        tail = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    public T get(int index) {
        Node<T> currentNode = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getData();
    }

    public void delete(int index) {
        int currentIndex = 0;
        Node<T> currentNode = head;
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (size == 0) {
            head = null;
            tail = null;
            return;
        }
        if (index == 0) {
            head = head.getNext();
            head.setPrevious(null);
        }
        if (index == size) {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        if (index > 0 && index < size) {
            while (currentIndex < index) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        }
    }

    //Un itrerador es un patrón de diseño
    public Iterator getIterator() {
        return new Iterator();
    }

    public ReverseIterator getReverseIterator() {
        return new ReverseIterator();
    }

    public void insert(T data,Position position, Iterator it) {
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = it.getCurrentNode();

        if (position == Position.AFTER) {
            newNode.setNext(currentNode.getNext());
            newNode.setPrevious(currentNode);
            currentNode.setNext(newNode);
            if (newNode.getNext() != null) {
                newNode.getNext().setPrevious(newNode);
            } else {
                tail = newNode;
            }
        } else if (position == Position.BEFORE) {
            newNode.setPrevious(currentNode.getPrevious());
            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);
            if (newNode.getPrevious() != null) {
                newNode.getPrevious().setNext(newNode);
            } else {
                head = newNode;
            }
        } else {
            System.out.println("Posicion no encontrada");
        }
        size++;
    }
}




