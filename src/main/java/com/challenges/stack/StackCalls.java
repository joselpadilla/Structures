package com.challenges.stack;

public class StackCalls {

    public static void main(String[] args) {
        System.out.println("_______________Constructor____________");
        constructor();
        System.out.println("_______________Push____________");
        push();
        System.out.println("_______________Pop____________");
        pop();
    }

    private static void constructor() {

        Stack myStack = new Stack(4);

        System.out.println(myStack.getTop().getValue());
        System.out.println(myStack.getHeight());

        System.out.println("\nStack:");
        myStack.printStack();
    }

    private static void push() {
        Stack myStack = new Stack(2);

        System.out.println("Before push():");
        System.out.println("--------------");
        System.out.println(myStack.getTop().getValue());
        System.out.println(myStack.getHeight());

        System.out.println("\nStack:");
        myStack.printStack();

        myStack.push(1);

        System.out.println("\n\nAfter push():");
        System.out.println("-------------");
        System.out.println(myStack.getTop().getValue());
        System.out.println(myStack.getHeight());

        System.out.println("\nStack:");
        myStack.printStack();
    }

    private static void pop() {
        Stack myStack = new Stack(2);
        myStack.push(1);

        // (2) Items - Returns 1 Node
        System.out.println(myStack.pop().getValue());
        // (1) Item - Returns 2 Node
        System.out.println(myStack.pop().getValue());
        // (0) Items - Returns null
        System.out.println(myStack.pop());
    }
}
