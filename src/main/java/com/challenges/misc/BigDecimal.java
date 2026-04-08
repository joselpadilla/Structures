package com.challenges.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BigDecimal {
    public static void main(String[] args) {
        System.out.println(bigDecimal(new String[] {
                "-100", "50", "0", "56.6","90","0.12",".12","02.34","000.000"
        }));//.forEach(System.out::println);
    }

    private static String bigDecimal(String[] arr) {
        List<String> list = Arrays.asList(arr);
        return list.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse("");
        //return list;
    }
}
