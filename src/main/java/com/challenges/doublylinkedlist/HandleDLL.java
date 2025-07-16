package com.challenges.doublylinkedlist;

public class HandleDLL {
    public static void main(String[] args) {
        System.out.println("_______________Constructor____________");
        testConstructor();
        System.out.println("_______________Append____________");
        append();
        System.out.println("_______________Remove Last____________");
        removeLast();
        System.out.println("_______________Prepend____________");
        prepend();
        System.out.println("_______________Remove First____________");
        removeFirst();
        System.out.println("_______________Get____________");
        get();
        System.out.println("_______________Set____________");
        set();
        System.out.println("_______________Insert____________");
        insert();
        System.out.println("_______________Remove____________");
        remove();
    }

    private static void testConstructor() {
        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();
    }

    private static void append() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);

        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();
    }

    private static void removeLast() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myDLL.removeLast().getValue());
        // (1) Item - Returns 1 Node
        System.out.println(myDLL.removeLast().getValue());
        // (0) Items - Returns null
        System.out.println(myDLL.removeLast());
    }

    private static void prepend() {
        DoublyLinkedList myDLL = new DoublyLinkedList(2);
        myDLL.append(3);

        System.out.println("Before prepend():");
        System.out.println("-----------------");
        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();

        myDLL.prepend(1);

        System.out.println("\n\nAfter prepend():");
        System.out.println("----------------");
        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();
    }

    private static void removeFirst() {
        DoublyLinkedList myDLL = new DoublyLinkedList(2);
        myDLL.append(1);

        // (2) Items - Returns 2 Node
        System.out.println(myDLL.removeFirst().getValue());
        // (1) Item - Returns 1 Node
        System.out.println(myDLL.removeFirst().getValue());
        // (0) Items - Returns null
        System.out.println(myDLL.removeFirst());
    }

    private static void get() {
        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);


        System.out.println(myDLL.get(3).getValue());
    }

    private static void set() {
        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);

        System.out.println("DLL before set():");
        myDLL.printList();

        myDLL.set(2, 99);

        System.out.println("\nDLL after set():");
        myDLL.printList();
    }

    private static void insert() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(3);

        System.out.println("DLL before insert():");
        myDLL.printList();

        myDLL.insert(1, 2);

        System.out.println("\nDLL after insert(2) in middle:");
        myDLL.printList();

        myDLL.insert(0, 0);

        System.out.println("\nDLL after insert(0) at beginning:");
        myDLL.printList();

        myDLL.insert(4, 4);

        System.out.println("\nDLL after insert(4) at end:");
        myDLL.printList();
    }

    private static void remove() {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before remove():");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(2).getValue());
        System.out.println("DLL after remove() in middle:");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(0).getValue());
        System.out.println("DLL after remove() of first node:");
        myDLL.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myDLL.remove(2).getValue());
        System.out.println("DLL after remove() of last node:");
        myDLL.printList();
    }
}
