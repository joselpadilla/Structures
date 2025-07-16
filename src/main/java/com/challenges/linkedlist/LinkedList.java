package com.challenges.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    Node head;
    Node tail;
    int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if(length == 0) {
            return null;
        }

        Node temp = head;
        Node pre = head;

        while(temp.getNext() != null) {
            pre = temp;
            temp = temp.getNext();
        }

        tail = pre;
        tail.setNext(null);
        length--;

        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) { return null; }
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        if(length == 0) { tail = null; }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) { return null; }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
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
        Node temp = get(index - 1);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) { return null; }
        if(index == 0) { return removeFirst(); }
        if(index == length - 1) { return removeLast(); }

        Node prev = get(index - 1);
        Node temp = prev.getNext();

        prev.setNext(temp.getNext());
        temp.setNext(null);
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after;
        Node before =  null;

        for(int i = 0; i < length; i++) {
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }

    public Node middleNode() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.getNext()!= null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public boolean hasLoop() {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast == slow) { return true; }
        }

        return false;
    }

    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for(int i = 0; i < k; i++) {
            if(fast == null) { return null; }
            fast = fast.getNext();
        }

        while(fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
    }

    public Node removeNthFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;

        for(int i = 0; i < n; i++) {
            fast = fast.getNext();
        }
        if(fast == null) { return head.getNext(); }

        while(fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        slow.setNext(slow.getNext().getNext());
        return head;
    }

    public void removeDuplicates() {
        Set<Integer> noDuplicates = new HashSet<>();

        Node previous = null;
        Node current = head;
        while(current != null) {
            if(noDuplicates.contains(current.getValue())) {
                previous.setNext(current.getNext());
                length -= 1;
            } else {
                noDuplicates.add(current.getValue());
                previous = current;
            }
            current = current.getNext();
        }
    }

    public int binaryToDecimal() {
        Node current = head;

        int sum = 0;

        while(current != null) {
            sum = (sum * 2) + current.getValue();
            current = current.getNext();
        }

        return sum;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.setNext(head);
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.getNext();
        }

        Node currentNode = previousNode.getNext();

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.getNext();
            currentNode.setNext(nodeToMove.getNext());
            nodeToMove.setNext(previousNode.getNext());
            previousNode.setNext(nodeToMove);
        }

        head = dummyNode.getNext();
    }

    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.getValue() < x) {
                prev1.setNext(current);
                prev1 = current;
            } else {
                prev2.setNext(current);
                prev2 = current;
            }
            current = current.getNext();
        }

        prev2.setNext(null);
        prev1.setNext(dummy2.getNext());

        head = dummy1.getNext();
    }

    public void swapPairs() {
        Node dummy = new Node(0);
        dummy.setNext(head);
        Node previous = dummy;
        Node first = head;

        while (first != null && first.getNext() != null) {
            Node second = first.getNext();

            // Perform the swap
            previous.setNext(second);
            first.setNext(second.getNext());
            second.setNext(first);

            // Move pointers
            previous = first;
            first = first.getNext();
        }

        head = dummy.getNext();
    }
}
