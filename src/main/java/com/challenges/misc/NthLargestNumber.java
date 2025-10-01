package com.challenges.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class NthLargestNumber {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 8, 9, 3, 4, 9, 10);
        int n = 2;
        numbers.stream()
                .distinct() // Remove duplicates
                .sorted(Collections.reverseOrder())
                .limit(n)// Sort in descending order
                .toList()
                .forEach(System.out::println); // Get the nth element

        Optional<Integer> nthLargest = numbers.stream()
                .distinct() // Remove duplicates
                .sorted(Collections.reverseOrder()) // Sort in descending order
                .skip(n - 1) // Skip the first n-1 elements
                .findFirst(); // Get the nth element

        if (nthLargest.isPresent()) {
            System.out.println("The " + n + "rd largest number is: " + nthLargest.get());
        } else {
            System.out.println("There is no " + n + "rd largest number.");
        }
    }
}