package com.challenges.linkedlist;

import java.util.Optional;

public class HandleLinkedList {

    public static void main(String[] args) {
/*
        System.out.println("--------------------Remove First----------------------");
        removeFirst();
        System.out.println("--------------------Remove Last----------------------");
        removeLast();
        System.out.println("--------------------Get----------------------");
        get();
        System.out.println("--------------------Set----------------------");
        set();
        System.out.println("--------------------Insert----------------------");
        insert();
        System.out.println("--------------------Remove----------------------");
        remove();
*/
        System.out.println("--------------------Reverse----------------------");
        reverse();
    }

    private static void removeLast() {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(7);
        linkedList.prepend(1);
        linkedList.printList();

        System.out.println();
        System.out.println(linkedList.removeLast().getValue());
        System.out.println(linkedList.removeLast().getValue());
        System.out.println(linkedList.removeLast().getValue());
        System.out.println(linkedList.removeLast());
    }
    private static void removeFirst() {
        LinkedList linkedList = new LinkedList(4);
        linkedList.append(7);
        linkedList.prepend(1);
        linkedList.printList();

        System.out.println();
        System.out.println(linkedList.removeFirst().getValue());
        System.out.println(linkedList.removeFirst().getValue());
        System.out.println(linkedList.removeFirst().getValue());
        System.out.println(linkedList.removeFirst());
    }

    private static void get() {
        LinkedList myLinkedList = new LinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(7);

        System.out.println(Optional.of(myLinkedList.get(3).getValue()).orElse(null));
    }

    private static void set() {
        LinkedList myLinkedList = new LinkedList(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);

        System.out.println("Linked List before set():");
        myLinkedList.printList();

        myLinkedList.set(2, 99);

        System.out.println("\nLinked List after set():");
        myLinkedList.printList();
    }

    private static void insert() {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(3);

        System.out.println("LL before insert():");
        myLinkedList.printList();

        myLinkedList.insert(1, 2);

        System.out.println("\nLL after insert(2) in middle:");
        myLinkedList.printList();

        myLinkedList.insert(0, 0);

        System.out.println("\nLL after insert(0) at beginning:");
        myLinkedList.printList();

        myLinkedList.insert(4, 4);

        System.out.println("\nLL after insert(4) at end:");
        myLinkedList.printList();
    }

    private static void remove() {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("LL before remove():");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).getValue());
        System.out.println("LL after remove() in middle:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(0).getValue());
        System.out.println("LL after remove() of first node:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).getValue());
        System.out.println("LL after remove() of last node:");
        myLinkedList.printList();
    }

    private static void reverse() {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);

        System.out.println("LL before reverse():");
        myLinkedList.printList();

        myLinkedList.reverse();

        System.out.println("\nLL after reverse():");
        myLinkedList.printList();
    }
}
