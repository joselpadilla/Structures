package com.challenges.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class NoDivisibleSubset {
    public static void main(String[] args) {
/*
        List<Integer> numbers = Arrays.asList(19, 10, 12, 10, 24, 25, 22);
        System.out.println(nonDivisibleSubset(4, numbers));
*/
        String s = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
        System.out.println(repeatedString(s, 736778906400L));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        IntStream.range(0, s.size()) // Outer loop for index i
                .flatMap(i -> IntStream.range(i + 1, s.size()) // Inner loop for index j (j > i)
                        .map(j -> s.get(i) + s.get(j)))
                .boxed()
                .filter(n -> n % k != 0)
                .forEach(System.out::println);// Map to the sum of the pair
        return 0;
    }

    public static long repeatedString(String s, long n) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int strLength = s.length();
        long countInSingle = 0;

        // Count 'a's in the original string
        for (int i = 0; i < strLength; i++) {
            if (s.charAt(i) == 'a') {
                countInSingle++;
            }
        }

        // Calculate how many complete repetitions we have
        long completeRepetitions = n / strLength;
        long remainingChars = n % strLength;
        long countInRemaining = 0;

        // Count 'a's in the remaining characters
        for (int i = 0; i < remainingChars; i++) {
            if (s.charAt(i) == 'a') {
                countInRemaining++;
            }
        }

        return (completeRepetitions * countInSingle) + countInRemaining;
    }
}
