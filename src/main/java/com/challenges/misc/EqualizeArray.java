package com.challenges.misc;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EqualizeArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 2, 3, 3));
        System.out.println(equalize(list));
    }

    private static int equalize(List<Integer> arr) {
        return arr.size() - Math.toIntExact(arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .orElse(new AbstractMap.SimpleEntry<>(-1, 0L)).getValue());
    }
}
