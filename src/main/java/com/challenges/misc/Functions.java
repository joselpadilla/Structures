package com.challenges.misc;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface TriFunction<R, T, U, V> {
    V apply(R r, T t, U u);
}

public class Functions {
    public static void main(String[] args) {
        int n = 5;
        Function<String, String> repeater = str -> n <= 0 ? "" : str.repeat(n);

        System.out.println(repeater.apply("yes"));

        BiFunction<Integer, String, String> repeater2 = (num, s) -> s.repeat(num);

        System.out.println(repeater2.apply(n,"repeater2"));

        TriFunction<Integer, Integer, String, String> threeFunction =
                (n1, n2, str) -> (n1 + n2) + str;
        System.out.println(threeFunction.apply(15,  20,  "sssss"));

        TriFunction<Integer, Integer, String, String> triFunction =
                (n1, n2, str) -> (n1 + n2) + str;

        // Corrected: Only 3 arguments (n, 20, "sssss") instead of 4
        System.out.println(threeFunction.apply(n, 20, "sssss"));
    }

}
