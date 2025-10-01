package com.challenges.misc;

public class HowManyGames {
    public static void main(String[] args) {
        System.out.printf("Total Games: %d",howManyGames(100, 19, 1, 180));
    }

    public static int howManyGames(int p, int d, int m, int s) {
        if (s < p) {
            return 0;
        }

        int gamesBought = 0;
        int currentPrice = p;
        int totalSpent = 0;

        // Buy games with decreasing price until we hit minimum price
        while (currentPrice >= m && totalSpent + currentPrice <= s) {
            totalSpent += currentPrice;
            gamesBought++;

            // Calculate next price, but don't go below minimum
            currentPrice = Math.max(m, currentPrice - d);
        }

        // If we still have budget after reaching minimum price, buy more at minimum price
        if (currentPrice == m) {
            int remainingBudget = s - totalSpent;
            int additionalGames = remainingBudget / m;
            gamesBought += additionalGames;
        }

        return gamesBought;
    }

}
