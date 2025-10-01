package com.challenges.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {

    public static int longestSubarray(List<Integer> a) {
        if (a == null || a.isEmpty()) return 0;
        if (a.size() == 1) return 1;

        // Sort the array to easily find elements with difference <= 1
        Collections.sort(a);

        int maxLength = 1;
        int left = 0;

        for (int right = 1; right < a.size(); right++) {
            // While the current element differs from left by more than 1, move left
            while (a.get(right) - a.get(left) > 1) {
                left++;
            }
            // Update max length if current window is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        List<Integer> test1 = Arrays.asList(4, 6, 5, 3, 3, 1);
        System.out.println(longestSubarray(test1)); // Expected: 5

    }
}