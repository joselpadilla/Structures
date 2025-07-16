package com.challenges.queue;

import lombok.Data;

@Data
public class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
}
