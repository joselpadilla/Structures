package com.challenges.misc;

import java.util.Arrays;

public class AppendAndDelete {
    public static void main(String[] args) {
        System.out.println(appendAndDelete("hackerhappy", "", 11));
    }

    private static String appendAndDelete(String s, String t, int k){
        int commonLength = 0;
        int minLength = Math.min(s.length(), t.length());

        // Find the length of the common prefix
        while (commonLength < minLength && s.charAt(commonLength) == t.charAt(commonLength)) {
            commonLength++;
        }

        int minOperations = (s.length() - commonLength) + (t.length() - commonLength);

        if (k < minOperations) {
            return "No";
        } else if (k >= s.length() + t.length()) {
            // We can delete all characters of s (s.length operations) and then build t (t.length operations)
            return "Yes";
        } else if ((k - minOperations) % 2 == 0) {
            // After min operations, remaining operations must be even (can be spent by adding and deleting)
            return "Yes";
        } else {
            return "No";
        }
    }
}
