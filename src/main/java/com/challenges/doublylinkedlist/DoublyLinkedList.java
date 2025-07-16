package com.challenges.doublylinkedlist;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.getValue());
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.getValue());
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.getValue());
            System.out.println("Tail: " + tail.getValue());
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        length ++;
    }

    public Node removeLast() {
        if(length == 0) {return null;}

        Node temp = tail;

        if(length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
            temp.setPrev(null);
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if(length ==  0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) {return null;}

        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
            temp.setNext(null);
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) { return null; }

        Node temp = head;
        if(index < length / 2) {
            for(int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        } else {
            temp = tail;
            for(int i = length -1; i > index; i--) {
                temp = temp.getPrev();
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if(temp != null) {
            temp.setValue(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) { return false; }

        if(index == 0) {
            prepend(value);
            return true;
        }

        if(index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.getNext();

        newNode.setPrev(before);
        newNode.setNext(after);
        before.setNext(newNode);
        after.setPrev(newNode);
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) { return null; }

        if(index == 0) { return removeFirst(); }
        if(index == length - 1) { return removeLast(); }

        Node temp = get(index);

        temp.getNext().setPrev(temp.getPrev());
        temp.getPrev().setNext(temp.getNext());
        temp.setPrev(null);
        temp.setNext(null);

        length--;
        return temp;
    }
}
