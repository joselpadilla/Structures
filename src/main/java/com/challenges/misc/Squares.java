package com.challenges.misc;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Double.NaN;

public class Squares {
    public static void main(String[] args) {
        System.out.println(squares(3, 9));
    }

    private static int squares(int a, int b) {

/*
        return Math.toIntExact(IntStream.range(a, b+1)
                //.boxed()
                .filter(i -> Math.sqrt(i) % 1 == 0)
                .count());
*/
/*
        int squares = 0;
        while(a <= b) {
            if(Math.sqrt(a) % 1 == 0) {
                squares += 1;
            }
            a += 1;
        }
        return squares;
*/
        double start = Math.ceil(Math.sqrt(a));
        double end = Math.floor(Math.sqrt(b));
        return (int) (end - start +1);

    }
}
