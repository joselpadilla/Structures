package com.challenges.misc;

import java.util.Arrays;
import java.util.List;

public class AngryProfessor {
    public static void main(String[] args) {
        System.out.println(angryProfessor(3, List.of(-1, -3, 4, 2)));
        System.out.println(angryProfessor(2, List.of(0, -1, 2, 1)));

    }

    private static String angryProfessor(int k, List<Integer> a) {
        int onTime = Math.toIntExact(a.stream().filter(t -> t <= 0).count());
        if(onTime >= k) {
            return "NO";
        }
        return "YES";
    }
}
