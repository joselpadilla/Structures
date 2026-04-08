package com.challenges.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveMinInPlace {
        public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 3, 1, 4));

            System.out.println("Original list: " + numbers);

            numbers.stream()
                    .min(Integer::compare)
                    .ifPresent(min -> numbers.removeAll(Collections.singleton(min)));

            System.out.println("List after removing min value: " + numbers);
        }
    }
