package com.challenges.bst;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("________________________Constructor________________________");
        constructTree();
        System.out.println("________________________Insert________________________");
        insert();
        System.out.println("________________________Contains________________________");
        contains();
    }

    private static void constructTree() {
        BinarySearchTree myBST = new BinarySearchTree();
        System.out.println("Root: " + myBST.getRoot());
    }

    private static void insert() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);
        myBST.inorderTraversal(myBST.getRoot());
        System.out.println();
    }

    private static void contains() {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);


        System.out.println("BST Contains 27:");
        System.out.println(myBST.contains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.contains(17));
    }
}
