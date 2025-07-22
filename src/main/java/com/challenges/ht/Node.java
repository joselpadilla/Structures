package com.challenges.ht;

import lombok.Data;

@Data
public class Node {
    private String key;
    private int value;
    private Node next;

    Node(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
