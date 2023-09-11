package com.company;

public class DoublyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private Node getNode(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index <= this.size / 2) {
            return this.findFromStart(index);
        }

        return this.findFromEnd(index);
    }

    private Node findFromStart(int index) {
        int currentIndex = 0;
        Node currentNode = this.head;

        while (currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return currentNode;
    }

    private Node findFromEnd(int index) {
        int currentIndex = this.size - 1;
        Node currentNode = this.tail;

        while (currentIndex > index) {
            currentNode = currentNode.getPrev();
            currentIndex--;
        }

        return currentNode;
    }

    public int getSize() {
        return this.size;
    }

    public Integer getFirst() {
        return this.head.getValue();
    }

    public Integer getLast() {
        return this.tail.getValue();
    }

    public Integer get(int index) {
        Node node = this.getNode(index);
        return node.getValue();
    }

    public Integer set(int index, int value) {
        Node node = this.getNode(index);
        node.setValue(value);
        return node.getValue();
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }

        this.size++;
    }

    public void add(int index, int value) {
        Node newNode = new Node(value);

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            if (index == 0) {
                newNode.setNext(this.head);
                this.head.setPrev(newNode);
                this.head = newNode;
            } else if (index == this.size) {
                this.tail.setNext(newNode);
                newNode.setPrev(this.tail);
                this.tail = newNode;
            } else {
                Node currentNode = this.getNode(index - 1);
                newNode.setNext(currentNode.getNext());
                newNode.setPrev(currentNode);
                currentNode.getNext().setPrev(newNode);
                currentNode.setNext(newNode);
            }
        }

        this.size++;
    }

    public boolean isPresent(int value) {
        Node currentNode = this.head;

        do {
            if (currentNode.getValue() == value) {
                return true;
            }

            currentNode = currentNode.getNext();
        } while (currentNode != this.tail);

        return false;
    }

    public Integer indexOf(int value) {
        if (isPresent(value)) {
            int currentIndex = 0;
            Node currentNode = this.head;

            while (currentIndex < this.size) {
                if (currentNode.getValue() == value) {
                    return currentIndex;
                }

                currentNode = currentNode.getNext();
                currentIndex++;
            }
        }

        throw new IllegalArgumentException("The specified value is not present in the list.");
    }

    public Integer lastIndexOf(int value) {
        if (isPresent(value)) {
            int currentIndex = this.getSize() - 1;
            Node currentNode = this.tail;
            int lastIndex = currentIndex;

            while (currentIndex >= 0) {
                if (currentNode.getValue() == value) {
                    lastIndex = currentIndex;
                }

                currentNode = currentNode.getPrev();
                currentIndex--;
            }

            return lastIndex;
        }

        throw new IllegalArgumentException("The specified value is not present in the list.");
    }

    public Integer remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int value = this.get(index);

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            if (index == 0) {
                this.head = this.head.getNext();
                this.head.setPrev(null);
            } else if (index == this.size - 1) {
                this.tail = this.tail.getPrev();
                this.tail.setNext(null);
            } else {
                Node nodeToRemove = this.getNode(index);
                nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
                nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
            }
        }

        this.size--;
        return value;
    }

    public void removeAll() {
        for (int i = 0; i < this.size; i++) {
            this.getNode(i).setNext(null);
        }

        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
