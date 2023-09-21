package com.company;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(1);
        list.add(15);
        list.add(16);
        list.add(1);

        list.print();

        System.out.println("Element location on position #2 from end to start is: " + list.getNthToLast(2));
        list.removeDuplicates();
        list.print();

        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        System.out.println("Removed: " + list.remove(2));
        list.print();

        System.out.println("Set on index 2 value of: " + list.set(1, 24));
        list.printBackwards();
    }
}
