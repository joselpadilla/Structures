package com.challenges.linkedlist;

public class HasLoop {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.tail.setNext(myLinkedList.head);

        System.out.println("Has Loop " + myLinkedList.hasLoop());
    }
}
