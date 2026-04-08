package com.challenges.misc;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BeautifulDays {
    public static void main(String[] args) {
        System.out.println(beautifulDays2(13, 45, 3));
    }

    private static int beautifulDays(int i, int j, int k) {
        int bd = 0;
        StringBuilder s = new StringBuilder();
        for(int start = i; start <= j; start++) {
            s.append(String.valueOf(start));
            int rev = Integer.parseInt(s.reverse().toString());
            if(Math.abs(start - rev) % k == 0) {
                bd++;
            }
            s.setLength(0);
        }
        return bd;
    }
    private static int beautifulDays2(int i, int j, int k) {

        return  Math.toIntExact(IntStream.range(i, j + 1)
                .map(e -> Math.abs(e - Integer.parseInt(
                        new StringBuilder()
                                .append(e)
                                .reverse()
                                .toString())))
                .filter(e -> e % k == 0)
                .count());
    }
}
