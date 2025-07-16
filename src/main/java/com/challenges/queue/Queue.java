package com.challenges.queue;

import lombok.Data;

@Data
public class Queue {

    private Node first;
    private Node last;
    private int length;

    Queue(int value) {
        first = new Node(value);
        last = first;
        length = 1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.getValue());
            System.out.println("Last: " + last.getValue());
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printQueue();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if(length == 0) { return null; }

        Node temp = first;

        if(length == 1) {
            first = null;
            last =null;
        } else {
            first = first.getNext();
            temp.setNext(null);
        }
        length--;
        return temp;
    }

}
