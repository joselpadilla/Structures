package com.challenges.misc;

import java.util.Arrays;

public class CatsAndMouse {
    public static void main(String[] args) {
        System.out.println(catAndMouse(1, 2, 3));
        System.out.println(catAndMouse(1, 3, 2));
    }

    private static String catAndMouse(int x, int y, int z) {
        int cat1 = 0;
        int cat2 = 0;

        if(x<z) {
           cat1 = z - x;
        } else if(x>z) {
            cat1 = x -z ;
        }

        if(y<z) {
            cat2 = z - y;
        } else if(y>z) {
            cat2 = y -z ;
        }

        if(cat1 < cat2) {
            return "Cat A";
        } else if (cat1 > cat2) {
            return "Cat B";
        }
        return "Mouse C";
    }
}
