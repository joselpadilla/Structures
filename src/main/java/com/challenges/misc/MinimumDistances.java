package com.challenges.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class MinimumDistances {
    public static void main(String[] args) {
        System.out.printf("Minimum Distance: %d%n",minimumDistances(List.of(7, 1, 3, 4, 1, 7)));
    }

    public static int minimumDistances(List<Integer> a) {

        return IntStream.range(0, a.size())
                .boxed()
                .flatMap(x -> IntStream.range(x+1, a.size())
                        .filter(y -> Objects.equals(a.get(y), a.get(x)))
                        .mapToObj(y ->  y - x)
                )
                .min(Integer::compareTo)
                .orElse(0);






/*
                        .mapToObj(y -> new ArrayList<Integer>(List.of(a.get(x), a.get(y))))
                .toList()
                .forEach(System.out::println);
*/
     }


}
