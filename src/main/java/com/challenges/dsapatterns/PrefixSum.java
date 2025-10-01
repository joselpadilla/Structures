package com.challenges.dsapatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixSum {
    public static void main(String[] args) {
        System.out.println(sumRange(new int[]{-2, 0, 3, -5, 2, -1}, 0, 5 ));

    }

    private static int sumRange(int [] arr, int left, int right) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        return  prefixSum[right + 1] - prefixSum[left];
    }
}
