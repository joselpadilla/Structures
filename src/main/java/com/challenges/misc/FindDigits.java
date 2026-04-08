package com.challenges.misc;

import java.util.Arrays;

public class FindDigits {
    public static void main(String[] args) {
        System.out.println(findDigits(124));
    }

    private static long findDigits(int n) {
/*
        return Math.toIntExact(String.valueOf(n).chars()
                .map(i -> (char)i - '0')
                .filter(i -> i != 0 && n % i == 0)
                .count());

*/
        return String.valueOf(n).chars()
                .filter(Character::isDigit)
                .count();


    }
}
