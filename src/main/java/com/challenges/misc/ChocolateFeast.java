package com.challenges.misc;

public class ChocolateFeast {
    public static void main(String[] args) {
        System.out.printf("bars: %d",chocolateFeast(16809, 123, 11668));
    }

    private static int chocolateFeast(int n, int c, int m) {

        int bars = n / c;
        int wrappers = bars;

        while (wrappers >= m) {
            int newBars = wrappers / m;
            bars += newBars;
            wrappers = wrappers % m + newBars;
        }

        return bars;

/* Below formula does not work for all cases, loop solution preferred
        int initialBars = n / c;
        return initialBars + (initialBars - 1) / (m - 1);
*/

    }
}
