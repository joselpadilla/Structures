package com.challenges.misc;

import java.math.BigDecimal;
import java.util.Arrays;

public class ExtraLongFactorial {
    public static void main(String[] args) {
        System.out.println(factorial(25));
    }

    private static BigDecimal factorial(int n){
        if(n == 0) return BigDecimal.ONE;
        BigDecimal result = factorial(n-1);
        return  result.multiply(BigDecimal.valueOf(n));
    }
}
