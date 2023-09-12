package com.company;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(1);
        list.add(15);
        list.add(16);
        list.add(1);

        list.removeDuplicates();

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        System.out.println("Removed: " + list.remove(4));
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Set on index 2 value of: " + list.set(2, 24));
    }
}
