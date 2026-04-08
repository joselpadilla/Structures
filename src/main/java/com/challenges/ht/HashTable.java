package com.challenges.ht;

import lombok.Data;

import java.util.ArrayList;

@Data
public class HashTable {
    int size = 7;
    Node dataMap[];

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if(dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.getKey() + ", " + temp.getValue() + "}");
                    temp = temp.getNext();
                }
            }
        }
    }

    public void set(String key, int value) {
        int index = hash(key);

        Node newNode = new Node(key, value);

        if(dataMap[index] == null) {
            dataMap[index] =  newNode;
        } else {
            Node temp = dataMap[index];
            if (temp.getKey() == key) {
                temp.setValue(temp.getValue() + value);
                return;
            }
            while (temp.getNext() != null) {
                temp = temp.getNext();
                if (temp.getKey() == key) {
                    temp.setValue(temp.getValue() + value);
                    return;
                }
            }
            temp.setNext(newNode);
        }
    }

    public int get(String key) {
        int index = hash(key);

        Node temp = dataMap[index];
        while(temp != null) {
            if(temp.getKey() == key) {
                return temp.getValue();
            }
            temp = temp.getNext();
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            Node temp = dataMap[i];
            while(temp != null) {
                allKeys.add(temp.getKey());
                temp = temp.getNext();
            }
        }
        return allKeys;
    }
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }
}
