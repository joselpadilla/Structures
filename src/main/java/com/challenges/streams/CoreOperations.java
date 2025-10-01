package com.challenges.streams;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class CoreOperations {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(List.of(
                new Person("Juan", 15, "M", new ArrayList<>(), "Ags"),
                new Person("Pablo", 17, "M", new ArrayList<>(), "Mx"),
                new Person("Laura", 18, "M", new ArrayList<>(), "Ags"),
                new Person("Gaby", 19, "M", new ArrayList<>(), "Mx"),
                new Person("Lula", 20, "M", new ArrayList<>(), "Ags")
        ));

        /* 1. Filtering a List:
            From a list of integers, create a new list containing only the even numbers.*/
        filtering();

        System.out.println("_______________________________");
        /* 2. Mapping Strings:
        From a list of strings, create a new list where each string is converted to uppercase.*/
        mappingStrings();

        System.out.println("_______________________________");
        /*3. Sum of Numbers:
        Calculate the sum of all integers in a list using reduce() and then using mapToInt().sum().*/
        sumOfNumbers();

        System.out.println("_______________________________");
        /*4. Find First:
        From a list of Person objects, find the first person who is older than 18.*/
        findFirstPerson(list);

        System.out.println("_______________________________");
        /*5. ToList Collector:
        From a list of Person objects, get a list of all their names.*/
        toList(list);

        System.out.println("_______________________________");
        /*6. ToSet Collector:
        From a list of words (with duplicates), collect them into a Set to remove duplicates.*/
        toSet();

        System.out.println("_______________________________");
        /* 7. ForEach Printing:
        Print all elements of a list using forEach().*/
        forEach(list);
    }

    private static void filtering() {
        List<Integer> list = new ArrayList<>(List.of(7, 15, 22, 99, 80, 30, 155, 201, 900));
        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    private static void mappingStrings() {
        List<String> list = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six", "seven"));
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    private static void sumOfNumbers() {
        List<Integer> list = new ArrayList<>(List.of(5, 10, 6, 20, 7, 30, 8, 40));

        System.out.printf("using reduce() operation: %d%n",
                list.stream().reduce(0, Integer::sum));
        System.out.printf("using mapToInt() and sum() operations: %d%n",
                list.stream().mapToInt(Integer::valueOf).sum());
    }

    private static void findFirstPerson(List<Person> list) {

        Person person = list
                .stream()
                .filter(p -> p.age() > 18)
                .findFirst()
                .orElse(null);
        if(person != null) {
            System.out.printf("name: %s, age: %d, gender: %s%n", person.name(), person.age(), person.gender());
        } else {
            System.out.printf("not found%n");
        }
    }

    private static void toList(List<Person> list) {

        list
                .stream()
                .map(Person::name)
                .forEach(System.out::println);
    }

    private static void toSet() {
        List<String> list = new ArrayList<>(List.of("one", "two", "one", "four", "one", "six", "two"));

        new LinkedHashSet<>(list).forEach(System.out::println);
    }

    private static void forEach(List<Person> list) {
        list.forEach(System.out::println);
    }
}
