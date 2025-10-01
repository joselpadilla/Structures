package com.challenges.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularArrayRotation {
    public static void main(String[] args) {
        circularArrayRotation(new ArrayList<>(List.of(1, 2, 3)), 2, new ArrayList<>(List.of(0, 1, 2)))
                .forEach(System.out::println);
    }

    private static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        while(k > 0){
            manualRightRotate(a, 1);
            k--;
        }

        return queries
                .stream()
                .map(a::get)
                .toList();
    }

    private static <T> void manualRightRotate(List<T> list, int rotationCount) {
        if (list == null || list.isEmpty() || rotationCount <= 0) {
            return;
        }

        rotationCount = rotationCount % list.size();

        for (int i = 0; i < rotationCount; i++) {
            // Remove last element and add it to the front
            T item = list.remove(list.size() - 1);
            list.add(0, item);
        }
    }
}
