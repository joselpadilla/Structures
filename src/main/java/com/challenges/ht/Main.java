package com.challenges.ht;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("_______________Constructor_______________");
        constructor();
        System.out.println("_______________Set_______________");
        set();
        System.out.println("_______________Get_______________");
        get();
        System.out.println("_______________Keys_______________");
        keys();
    }

    private static void constructor() {
        HashTable myHashTable = new HashTable();
        myHashTable.printTable();
    }

    private static void set() {
        HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);

        myHashTable.printTable();
    }

    private static void get() {
        HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        System.out.println("Lumber:");
        System.out.println( myHashTable.get("lumber") );

        System.out.println("\nBolts:");
        System.out.println( myHashTable.get("bolts") );
    }

    private static void keys() {
        HashTable myHashTable = new HashTable();

        myHashTable.set("paint", 20);
        myHashTable.set("bolts", 40);
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        System.out.println( myHashTable.keys() );
    }
}
