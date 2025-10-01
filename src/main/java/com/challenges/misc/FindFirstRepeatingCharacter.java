package com.challenges.misc;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatingCharacter
{
    public static void main(String[] args)
    {
        String input = "repeating-characters";

        input.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Character::charValue, HashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().ifPresent(System.out::println);

        Set<Character> elements = new HashSet<>();
        input.chars().mapToObj(ch -> (char) ch)
                .filter(ch -> !elements.add(ch))
                .findFirst().ifPresent(System.out::println);

        System.out.printf("Max repeated char: %s%n", input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(new AbstractMap.SimpleEntry<>('*',0L)));


    }
}