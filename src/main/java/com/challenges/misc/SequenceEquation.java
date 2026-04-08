package com.challenges.misc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequenceEquation {
    public static void main(String[] args) {
        permutationEquation(List.of(4, 3, 5, 1, 2)).forEach(System.out::println);
    }

    private static List<Integer> permutationEquation(List<Integer> p) {
        // Write your code here

        return IntStream.range(1, p.size() + 1)
                .map(num -> p.indexOf(p.indexOf(num) + 1) + 1)
                .boxed()
                .collect(Collectors.toList());

    }
}
