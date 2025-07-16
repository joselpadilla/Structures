package com.challenges.linkedlist;

import lombok.Data;

@Data
public class Node {
    private int value;
    private Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
