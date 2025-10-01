package com.challenges.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JumpingOnTheClouds {
    public static void main(String[] args) {
        System.out.println("Energy : " + jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2));
        System.out.println(jumpingOnClouds(Arrays.asList(0, 0, 1, 0, 0, 1, 0)));
    }

    private static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int n = c.length;
        int currentIndex = 0;
        do {
            energy -= c[currentIndex] == 0 ? 1 : 3;
            currentIndex = (currentIndex + k) % n; // Move to the next element circularly
        } while (currentIndex != 0);
        return energy;
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int n = c.size();
        List<Integer> memo = new ArrayList<>(Collections.nCopies(n, 0));
        return minJumps(c, 0, memo);
    }

    private static int minJumps(List<Integer> c, int position, List<Integer> memo) {
        int n = c.size();

        // Base case: reached the end
        if (position >= n - 1) {
            return 0;
        }

        // If current cloud is thunderhead, return large number
        if (c.get(position) == 1) {
            return Integer.MAX_VALUE;
        }

        // Return memoized result if available
        if (memo.get(position) != 0) {
            return memo.get(position);
        }

        int jump1 = Integer.MAX_VALUE;
        int jump2 = Integer.MAX_VALUE;

        // Try jumping 1 cloud
        if (position + 1 < n && c.get(position + 1) == 0) {
            jump1 = minJumps(c, position + 1, memo);
        }

        // Try jumping 2 clouds
        if (position + 2 < n && c.get(position + 2) == 0) {
            jump2 = minJumps(c, position + 2, memo);
        }

        // Take minimum of both options and add 1 for current jump
        int result = Math.min(jump1, jump2);
        if (result != Integer.MAX_VALUE) {
            result += 1;
        }

        memo.set(position, result);
        return result;
    }
}
