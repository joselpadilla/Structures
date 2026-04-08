package com.challenges.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntermediateOperations {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(List.of(
                new Person("Juan", 15, "M", new ArrayList<>(), "Ags"),
                new Person("Pablo", 17, "M", new ArrayList<>(), "Mx"),
                new Person("Laura", 18, "M", new ArrayList<>(), "Ags"),
                new Person("Gaby", 19, "M", new ArrayList<>(), "Mx"),
                new Person("Lula", 20, "M", new ArrayList<>(), "Ags")
        ));

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

/*
        */
/*8. Grouping By:
        Group a list of Transaction objects by their type.*//*

        groupingBy(transactions);


        System.out.println("_______________________________");
        */
/* 9. Averaging:
        Calculate the average age of a list of Person objects.*//*

        ageAverage(persons);

        System.out.println("_______________________________");
        */
/* 10. Partitioning:
        Partition a list of Person objects into two groups: adults (age >= 18) and minors.*//*

        partition(persons);

        System.out.println("_______________________________");
        */
/* 11. Joining Strings:
        From a list of Person names, create a single string concatenated with a comma and a space. (e.g., "John, Jane, Jack")*//*

        joining(persons);

        System.out.println("_______________________________");
        */
/* 12. Max/Min Value:
        Find the Transaction with the highest value. Do the same for the lowest.*//*

        maxMin(transactions);

        System.out.println("_______________________________");
        */
/* 13. Multiple Aggregations:
        Get a summary statistics object (count, sum, min, average, max) for the ages in a list of Person objects.*//*

        multipleAggregations(persons);

        System.out.println("_______________________________");
        */
/* 14. Mapping after Grouping:
        Group Person objects by city, but then map the groups to just a list of their names instead of the full*//*

        mappingAfterGrouping(persons);
*/
        System.out.printf("Rating ID with highest average: %d%n",
                maxAverageRating(new int[][]{{250,10}, {320,5}, {538, 10}, {320, 10},  {5, 10}}));
    }

    private static void groupingBy(List<Transaction> transactions) {
        transactions.stream().collect(Collectors.groupingBy(Transaction::type))
                .forEach((k,v) -> {System.out.println(k + " ");
                v.forEach(System.out::println);});
    }

    private static void ageAverage(List<Person> persons) {
        System.out.printf("Using averagingInt() : %.2f%n",
                persons.stream().collect(Collectors.averagingInt(Person::age)));
        System.out.printf("Using mapToDouble() andaverage() : %.2f%n",
                persons.stream().mapToDouble(Person::age).average().orElse(0.0));
    }

    private static void partition(List<Person> persons) {
        persons.stream().collect(Collectors.partitioningBy(p -> p.age() >= 18))
                .forEach((k,v) -> {
                    System.out.println(k ? "Adults " : "Childs ");
                    v.forEach(System.out::println);
                    System.out.println();
                });
    }

    private static void joining(List<Person> persons) {
        System.out.printf("Using joining() : %s%n",
                persons.stream().map(Person::name).collect(Collectors.joining(", ")));
    }

    private static void maxMin(List<Transaction> transactions) {
        System.out.printf("Max Transaction value : %s%n",
                transactions.stream().max(Comparator.comparing(Transaction::value)).orElse(new Transaction("", 0.0, 0)));
        System.out.printf("Min Transaction value : %s%n",
                transactions.stream().min(Comparator.comparing(Transaction::value)).orElse(new Transaction("", 0.0, 0)));
    }

    private static void multipleAggregations(List<Person> persons) {
        IntSummaryStatistics personStat = persons.stream().collect(Collectors.summarizingInt(Person::age));

        System.out.printf("Total Persons: %d%n", personStat.getCount());
        System.out.printf("Persons age sum: %d%n", personStat.getSum());
        System.out.printf("Min Persons age: %d%n", personStat.getMin());
        System.out.printf("Max Persons age: %d%n", personStat.getMax());
        System.out.printf("Persons age average: %.2f%n", personStat.getAverage());
    }

    private static void mappingAfterGrouping(List<Person> persons) {
        persons.stream().collect(Collectors.groupingBy(Person::city,
                Collectors.mapping(Person::name, Collectors.toList())))
                .forEach((k,v) -> {
                    System.out.println(k + " ");
                    v.forEach(System.out::println);
                    System.out.println();
                });

    }

    private static Integer closestZero(List<Integer> list) {
        return list.stream().min(Comparator.<Integer>comparingInt(Math::abs)
                .thenComparing(Comparator.reverseOrder())).orElse(0);
    }

    private static Integer maxAverageRating(int[][] arr) {

        return Arrays.stream(arr)
                .collect(Collectors.groupingBy(entry -> entry[0], LinkedHashMap::new, Collectors.averagingInt(entry -> entry[1])))
                .entrySet().stream()
                .max(
                        Comparator.<Map.Entry<Integer, Double>>comparingDouble(Map.Entry::getValue).thenComparingInt(Map.Entry::getKey)
                ).map(Map.Entry::getKey).orElse(0);

/*        return Arrays.stream(arr)
                .map(row -> Arrays.stream(row).boxed().toList())
                .toList().stream().collect(
                Collectors.groupingBy(List::getFirst, Collectors.averagingInt(l -> l.get(1))))
                .entrySet().stream()
                .max(
                        Comparator.<Map.Entry<Integer, Double>>comparingDouble(Map.Entry::getValue).thenComparingInt(Map.Entry::getKey)
                ).map(Map.Entry::getKey).orElse(0);

*/
    }
}
