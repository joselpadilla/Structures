package com.challenges.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SAilpointChhalenge {
    public static void main(String[] args) {
        List<String> airlines = List.of("James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael",
                "Linda", "William", "Elizabeth", "David", "Barbara", "Richard", "Susan", "Charles", "Jessica", "Joseph",
                "Sarah", "Thomas", "Karen", "Christopher", "Nancy", "Daniel", "Margaret", "Paul", "Lisa", "Mark", "Betty",
                "Donald", "Dorothy", "George", "Sandra", "Kenneth", "Ashley", "Steven", "Kimberly", "Edward", "Donna",
                "Brian", "Carol", "Ronald", "Michelle", "Anthony", "Emily", "Kevin", "Helen", "Jason", "Amanda", "Matthew",
                "Melissa");
        System.out.println(getChepestTicket(airlines));
    }

    private static int getChepestTicket(List<String> airlines) {

        return airlines.stream().parallel().map(al -> generateRandom(-1, 100)).filter(price -> price != -1).min(Integer::compareTo).orElse(-1);


    }

    private static int generateRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;

    }
}
