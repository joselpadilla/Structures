package com.challenges.misc;

import java.util.Arrays;

public class ViralAdvertising {
    public static void main(String[] args) {
        System.out.println("People liked: " + viralAdvertising(3));
    }

    private static int viralAdvertising(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 2;
        }

        int shared = 5;
        int liked = 2;
        int cumulative = 2;

        for (int i = 2; i <= n; i++) {
            shared = liked * 3;
            liked = Math.floorDiv(shared, 2);
            cumulative += liked;
        }
        return cumulative;
    }
}
