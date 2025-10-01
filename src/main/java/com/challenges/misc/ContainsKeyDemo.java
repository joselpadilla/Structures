package com.challenges.misc;

import java.util.HashMap;
import java.util.Map;

public class ContainsKeyDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        int myKey = 2;

        System.out.printf("Contains key %d? %s", myKey, map.containsKey(2));
    }
}
