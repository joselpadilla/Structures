package com.challenges.streams;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Advanced {
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>(List.of(
                new Transaction("Buy", 15, 1),
                new Transaction("Sell", 17, 2),
                new Transaction("Buy", 18, 3),
                new Transaction("Sell", 19, 4),
                new Transaction("Buy", 20, 5),
                new Transaction("Sell", 22, 6),
                new Transaction("Buy", 25, 7),
                new Transaction("Sell", 10, 8),
                new Transaction("Buy", 5, 9)
        ));

        List<Person> persons = new ArrayList<>(List.of(
                new Person("Juan", 15, "M",
                        new ArrayList<>(List.of("movies", "running", "reading", "music")), "Ags"),
                new Person("Pablo", 17,"M",
                        new ArrayList<>(List.of("movies", "yoga", "reading", "music")), "Mx"),
                new Person("Laura", 18, "M",
                        new ArrayList<>(List.of("movies", "running", "reading", "music")), "Ags"),
                new Person("Gaby", 19, "M",
                        new ArrayList<>(List.of("movies", "running", "reading", "climb")), "Mx"),
                new Person("Lula", 20, "M",
                        new ArrayList<>(List.of("movies", "running", "reading", "music")), "Ags"),
                new Person("Jose", 21, "M",
                        new ArrayList<>(List.of("movies", "running", "reading", "music")), "London")
        ));

        /* 21 Nested Collections:
        You have a List<List<Integer>>. Flatten it into a single List<Integer> and then find the maximum value.*/
        nestedCollections();

        System.out.println("_______________________________");
        /* 22. Complex Grouping & Aggregation:
        For each transaction type, calculate the total sum of all transactions of that type. The result should be a Map<String, Double>.*/
        complexGrouping(transactions);

        System.out.println("_______________________________");
        /* 23. Filtering within Groups:
        Group people by city, but only include people who are older than 18 in the resulting groups.*/
        filteringGroup(persons);

        System.out.println("_______________________________");
        /* 23. Finding Most Frequent Element:
        Find the most frequently occurring element in a list. (Hint: use groupingBy with counting(), then find the max value in the resulting map by value).*/
        frequent();
        
    }

    private static void nestedCollections() {
        List<List<Integer>> list = new ArrayList<>(List.of(
                List.of(10, 25, 8), List.of(1, 99, 42), List.of(112, 5, 33), List.of(22, 7, 14), List.of(50, 6, 88),
                List.of(4, 1, 9), List.of(77, 3, 11), List.of(2, 10, 20), List.of(9, 15, 25), List.of(30, 40, 50),
                List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9), List.of(10, 11, 12), List.of(13, 14, 15),
                List.of(16, 17, 18), List.of(19, 20, 21), List.of(22, 23, 24), List.of(25, 26, 27), List.of(28, 29, 30),
                List.of(31, 32, 33), List.of(34, 35, 36), List.of(37, 38, 39), List.of(40, 41, 42), List.of(43, 44, 45),
                List.of(46, 47, 48), List.of(49, 50, 51), List.of(52, 53, 54), List.of(55, 56, 57), List.of(58, 59, 60)
        ));

        list.stream().flatMap(Collection::stream).max(Integer::compareTo).ifPresentOrElse(System.out::println, () -> System.out.println("Nothing"));
    }

    private static void complexGrouping(List<Transaction> transactions) {
        transactions.stream()
                .collect(Collectors
                        .groupingBy(Transaction::type, LinkedHashMap::new, Collectors.summingDouble(Transaction::value)))
                .forEach((key, value) -> System.out.printf("%s sum = %.2f%n", key, value));
    }

    private static void filteringGroup(List<Person> persons) {
        persons
                .stream()
                .collect(Collectors
                        .groupingBy(Person::city,
                                Collectors
                                        .filtering(p -> p.age() > 18, Collectors.toList())))
                .forEach((key, value) -> System.out.printf("%s %s%n", key, value));
    }

    private static void frequent() {
        List<String> list = new ArrayList<>(List.of(
                "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon", "mango", "nectarine",
                "orange", "peach", "pear", "pineapple", "plum", "raspberry", "strawberry", "tangerine", "watermelon",
                "zucchini", "apple", "apple", "apple", "apple", "apple", "apple", "apple", "apple", "apple", "apple",
                "zucchini", "zucchini", "zucchini"
        ));

        list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),  Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nothing"));

    }
}
