package com.challenges.doublylinkedlist;

import lombok.Data;

@Data
public class Node {
    private int value;
    private Node prev;
    private Node next;

    Node(int value) {
        this.value = value;
    }
}
