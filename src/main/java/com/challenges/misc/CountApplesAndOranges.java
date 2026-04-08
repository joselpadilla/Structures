package com.challenges.misc;

import java.util.List;

public class CountApplesAndOranges {

    public static void main(String[] args) {
        countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
    }

    private static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here

        System.out.println(apples.stream().parallel().filter(apple -> a + apple >= s && a + apple <= t)
                .count());
        System.out.println(oranges.stream().parallel().filter(orange -> b + orange >= s && b + orange <= t)
                .count());

    }
}
