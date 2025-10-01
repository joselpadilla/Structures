package com.challenges.misc;

public class TaumBday {
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here

/*
        if(((long) z == (long) bc && (long) z == (long) wc) || ((long) z > (long) bc && (long) z > (long) wc)) {
            return ((long) b * (long) bc) + ((long) w * (long) wc);
        } else if ((long) bc > (long) wc) {
            return ((long) b * (((long) wc + (long) z) > (long) bc ? (long) bc : (long) wc + (long) z)) + ((long) w * (long) wc);
        } else {
            return ((long) w * (((long) bc + (long) z) > (long) wc ? (long) wc : (long) bc + (long) z)) + ((long) b * (long) bc);
        }
*/

        // Convert all inputs to long to prevent overflow


        // Calculate the cost if we buy directly
        long directCost = ((long)b * (long)bc) + ((long)w * (long) wc);

        // Calculate the cost if we convert black to white
        long convertBlackToWhite = ((long)b * ((long) wc + (long)z)) + ((long)w * (long) wc);

        // Calculate the cost if we convert white to black
        long convertWhiteToBlack = ((long)b * (long)bc) + ((long)w * ((long)bc + (long)z));

        // Return the minimum of all three options
        return Math.min(directCost, Math.min(convertBlackToWhite, convertWhiteToBlack));


    }

    public static void main(String[] args) {
/*
        System.out.printf("Total: %d%n",taumBday(384, 887, 2778, 6916, 7794));
        System.out.printf("Total: %d%n",taumBday(336, 387,493, 6650, 1422));
        System.out.printf("Total: %d%n",taumBday(363, 28,8691, 60, 7764));
        System.out.printf("Total: %d%n",taumBday(927, 541, 3427, 9173, 5737));
*/
        System.out.printf("Total: %d%n",taumBday(95677, 39394, 86983, 311224, 588538));
/*
        System.out.printf("Total: %d%n",taumBday(531, 863, 5124, 4068, 3136));
        System.out.printf("Total: %d%n",taumBday(930, 803,  4023, 3059, 3070));
        System.out.printf("Total: %d%n",taumBday(168, 394, 8457, 5012, 8043));
        System.out.printf("Total: %d%n",taumBday(230, 374,  4422, 4920, 3785));
        System.out.printf("Total: %d%n",taumBday(538, 199, 4325, 8316, 4371));
*/
    }
}
