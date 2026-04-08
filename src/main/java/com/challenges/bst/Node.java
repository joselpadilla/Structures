package com.challenges.bst;

import lombok.Data;

@Data
public class Node {
    private int value;
    private Node left;
    private Node right;

    Node(int value) {
        this.value = value;
    }
}
