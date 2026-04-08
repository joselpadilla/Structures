package com.challenges.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ElectronicShop {
    public static void main(String[] args) {
        int[] keyboards =  new int[]{3, 1};
        int[] drives =  new int[]{5,3,8};

        System.out.println("total = " + getMoneySpent(keyboards, drives, 10));
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        return Arrays.stream(keyboards).boxed()
                .flatMap(l1 -> Arrays.stream(drives).boxed().map(l2 -> l1 + l2))
                .sorted(Comparator.reverseOrder())
                .filter(n -> n <= b)
                .findFirst()
                .orElse(-1);

    }

}
