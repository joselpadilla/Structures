package com.challenges.linkedlist;

public class BinaryToDecimal {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(0);
        myLinkedList.append(0);

        myLinkedList.printList();
        System.out.println("_____________________________________________");
        System.out.println("Decimal number is " + myLinkedList.binaryToDecimal());
    }
}
