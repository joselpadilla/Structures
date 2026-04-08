package com.challenges.misc;

import java.util.ArrayList;
import java.util.List;

public class KaprekarNumbers {
    public static void main(String[] args) {
        kaprekarNumbers(1, 100);
    }

    private static void kaprekarNumbers(int p, int q) {
        List<Long> list = new ArrayList<>();
        for(long i = p; i <= q; i++){
            long d = Long.toString(i).length();
            String sqr = Long.toString((long) Math.pow(i, 2));
            String r = sqr.substring(sqr.length() - (int)d);
            String l = sqr.substring(0, sqr.length() - (int)d);
            Long result = Long.parseLong(!l.isEmpty() ? l : "0") + Long.parseLong(!r.isEmpty() ? r : "0");
            if(result.equals(i)){
                list.add(result);
            }
            System.out.printf("sqr = %s, left = %s, right = %s, result = %d%n", sqr, l, r, result);
            if(!list.isEmpty()) {
                list.forEach(n -> System.out.printf("%d ", n));
            } else {
                System.out.print("Ivalid Range");
            }
        }
    }

}
