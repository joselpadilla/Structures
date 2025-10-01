package com.challenges.misc;

import java.util.*;
import java.util.stream.Collectors;

public class QueenAttack {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Initialize the maximum possible moves in all 8 directions
        int up = n - r_q;
        int down = r_q - 1;
        int right = n - c_q;
        int left = c_q - 1;
        int upRight = Math.min(up, right);
        int upLeft = Math.min(up, left);
        int downRight = Math.min(down, right);
        int downLeft = Math.min(down, left);

        // Convert obstacles to a set for O(1) lookup
/*
        Set<String> obstacleSet = new HashSet<>();
        for (List<Integer> obstacle : obstacles) {
            obstacleSet.add(obstacle.get(0) + "," + obstacle.get(1));
        }
*/

        Set<String> obstacleSet = obstacles
                .stream()
                .map(o -> o.getFirst() + "," + o.get(1))
                .collect(Collectors.toSet());


        // Check each direction for obstacles
        // Up direction
        for (int i = 1; i <= up; i++) {
            if (obstacleSet.contains((r_q + i) + "," + c_q)) {
                up = i - 1;
                break;
            }
        }

        // Down direction
        for (int i = 1; i <= down; i++) {
            if (obstacleSet.contains((r_q - i) + "," + c_q)) {
                down = i - 1;
                break;
            }
        }

        // Right direction
        for (int i = 1; i <= right; i++) {
            if (obstacleSet.contains(r_q + "," + (c_q + i))) {
                right = i - 1;
                break;
            }
        }

        // Left direction
        for (int i = 1; i <= left; i++) {
            if (obstacleSet.contains(r_q + "," + (c_q - i))) {
                left = i - 1;
                break;
            }
        }

        // Up-Right direction
        for (int i = 1; i <= upRight; i++) {
            if (obstacleSet.contains((r_q + i) + "," + (c_q + i))) {
                upRight = i - 1;
                break;
            }
        }

        // Up-Left direction
        for (int i = 1; i <= upLeft; i++) {
            if (obstacleSet.contains((r_q + i) + "," + (c_q - i))) {
                upLeft = i - 1;
                break;
            }
        }

        // Down-Right direction
        for (int i = 1; i <= downRight; i++) {
            if (obstacleSet.contains((r_q - i) + "," + (c_q + i))) {
                downRight = i - 1;
                break;
            }
        }

        // Down-Left direction
        for (int i = 1; i <= downLeft; i++) {
            if (obstacleSet.contains((r_q - i) + "," + (c_q - i))) {
                downLeft = i - 1;
                break;
            }
        }

        // Sum all possible moves
        return up + down + right + left + upRight + upLeft + downRight + downLeft;
    }

    public static void main(String[] args) {
        // Test case 1
        int n1 = 4;
        int k1 = 0;
        int r_q1 = 4;
        int c_q1 = 4;
        List<List<Integer>> obstacles1 = new ArrayList<>();

        System.out.println("Test 1: " + queensAttack(n1, k1, r_q1, c_q1, obstacles1));
        // Expected: 9 (queen at corner of 4x4 board)

        // Test case 2
        int n2 = 5;
        int k2 = 3;
        int r_q2 = 4;
        int c_q2 = 3;
        List<List<Integer>> obstacles2 = Arrays.asList(
                Arrays.asList(5, 5),
                Arrays.asList(4, 2),
                Arrays.asList(2, 3)
        );

        System.out.println("Test 2: " + queensAttack(n2, k2, r_q2, c_q2, obstacles2));
        // Expected: 10

        // Test case 3
        int n3 = 1;
        int k3 = 0;
        int r_q3 = 1;
        int c_q3 = 1;
        List<List<Integer>> obstacles3 = new ArrayList<>();

        System.out.println("Test 3: " + queensAttack(n3, k3, r_q3, c_q3, obstacles3));
        // Expected: 0 (only one square)
    }
}