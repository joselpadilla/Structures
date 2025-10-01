package com.challenges.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulTriplets {
    public static void main(String[] args) {
        System.out.printf("Beautiful Triplets = %d%n", beautifulTriplets(3, List.of(1, 2, 4, 5, 7, 8, 10)));
        System.out.printf("Beautiful Triplets = %d%n",
                beautifulTriplets(3, List.of(1, 6, 7, 7, 8, 10, 12, 13, 14, 19)));
    }

    public static int beautifulTriplets(int d, List<Integer> arr) {
        return Math.toIntExact(arr.stream()
                .parallel()
                .filter(s -> arr.contains(s + d) && arr.contains(s + 2 * d))
                .count());
    }

}
