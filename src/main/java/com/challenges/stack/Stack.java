package com.challenges.stack;

import lombok.Data;

@Data
public class Stack {
    private Node top;
    private int height;

    Stack(int value) {
        this.top = new Node(value);
        this.height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.getValue());
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if(height == 0) {

            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if(height == 0) { return null; }

        Node temp = top;
        top = top.getNext();
        temp.setNext(null);
        height--;
        return temp;
    }
}
