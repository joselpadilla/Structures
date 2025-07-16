package com.challenges.queue;

public class QueueCall {
    public static void main(String[] args) {
        System.out.println("_______________Constructor____________");
        constructor();
        System.out.println("_______________Enqueue____________");
        enqueue();
        System.out.println("_______________Dequeue____________");
        dequeue();
    }

    private static void constructor() {
        Queue myQueue = new Queue(4);

        System.out.println(myQueue.getFirst().getValue());
        System.out.println(myQueue.getLast().getValue());
        System.out.println(myQueue.getLength());

        System.out.println("\nQueue:");
        myQueue.printQueue();
    }

    private static void enqueue() {
        Queue myQueue = new Queue(2);

        System.out.println("Before enqueue():");
        System.out.println("--------------");
        System.out.println(myQueue.getFirst().getValue());
        System.out.println(myQueue.getLast().getValue());
        System.out.println(myQueue.getLength());

        System.out.println("\nQueue:");
        myQueue.printQueue();

        myQueue.enqueue(1);

        System.out.println("\n\nAfter enqueue():");
        System.out.println("-------------");
        System.out.println(myQueue.getFirst().getValue());
        System.out.println(myQueue.getLast().getValue());
        System.out.println(myQueue.getLength());

        System.out.println("\nQueue:");
        myQueue.printQueue();
    }

    private static void dequeue() {
        Queue myQueue = new Queue(2);
        myQueue.enqueue(1);

        // (2) Items - Returns 2 Node
        System.out.println(myQueue.dequeue().getValue());
        // (1) Item - Returns 1 Node
        System.out.println(myQueue.dequeue().getValue());
        // (0) Items - Returns null
        System.out.println(myQueue.dequeue());
    }
}
