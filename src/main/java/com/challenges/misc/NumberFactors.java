package com.challenges.misc;

import java.util.List;

public class NumberFactors {

    // Function to find GCD of two numbers
    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to find LCM of two numbers
    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    // Function to get total number of integers between the two arrays
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Find LCM of all elements in array a
        int currentLcm = a.get(0);
        for (int num : a) {
            currentLcm = lcm(currentLcm, num);
        }

        // Find GCD of all elements in array b
        int currentGcd = b.get(0);
        for (int num : b) {
            currentGcd = gcd(currentGcd, num);
        }

        // Count how many multiples of LCM are factors of GCD
        int count = 0;
        for (int multiple = currentLcm; multiple <= currentGcd; multiple += currentLcm) {
            if (currentGcd % multiple == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> a = List.of(2, 4);
        List<Integer> b = List.of(16, 32, 96);
        System.out.println(getTotalX(a, b)); // Output: 3
    }
}
