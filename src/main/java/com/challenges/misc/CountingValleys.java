package com.challenges.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CountingValleys {
    public static void main(String[] args) {
        int steps = 8;
        String path = "UDDDUDUU";
        System.out.println(countingValleys(steps, path)); // Output: 1

        steps = 12;
        path = "DDUUDDUDUUUD";
        System.out.println(countingValleys(steps, path)); // Output: 2
    }

    private static int countingValleys(int steps, String path) {
        int altitude = 0; // Start at sea level
        int valleyCount = 0;

        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            int previousAltitude = altitude;

            // Update altitude based on step
            if (step == 'U') {
                altitude++;
            } else if (step == 'D') {
                altitude--;
            }

            // Check if we just came up to sea level from a valley
            if (previousAltitude == -1 && altitude == 0) {
                valleyCount++;
            }
        }

        return valleyCount;
    }
}
