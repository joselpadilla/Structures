package com.challenges.streams;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateComplex {
    public static void main(String[] args) {

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

/*        *//* 15. FlatMap:
        From a list of Person objects, get a combined list of all their hobbies (without duplicates).
         (Hint: flatMap to flatten the list of lists, then use a Set).*//*
        flatten(persons);

        System.out.println("_______________________________");
        *//* 16. Sorting:
        Sort a list of Person objects by age in descending order. Then sort by name ascending if ages are equal.*//*
        sorting(persons);

        System.out.println("_______________________________");
        *//* 17. AnyMatch/AllMatch/NoneMatch:
        Check if any Person in the list is from "London". Check if all people are older than 14. Check if no one has the name "Alice".*//*
        any(persons);

        System.out.println("_______________________________");
        *//* 18. Distinct:
        Get a list of distinct transaction types from a list of Transaction objects.*//*
        distinct(transactions);

        System.out.println("_______________________________");
        *//* 19. Skip/Limit:
        From a large list of integers, get the second, third, and fourth elements after sorting them. (Hint: sort, skip(1), limit(3)).*//*
        skip();

        System.out.println("_______________________________");
        *//* 20. Reduce for Custom Logic:
        Use reduce to find the longest string in a list.*//*
        customReduce();*/
        bestSeller();
    }

    private static void flatten(List<Person> persons) {
        persons.stream()
                .map(Person::hobbies)
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    private static void sorting(List<Person> persons) {
        persons.stream().sorted(Comparator.comparing(Person::age).reversed()
                .thenComparing(Person::name))
                .forEach(System.out::println);

    }

    private static void any(List<Person> persons) {
        System.out.printf("Any Person from London: %s%n", persons.stream().anyMatch(p -> p.city().equals("London")));
        System.out.printf("All Person older than 14: %s%n", persons.stream().allMatch(p -> p.age() > 14));
        System.out.printf("No one is Alice: %s%n", persons.stream().noneMatch(p -> p.name().equals("Alice")));
    }

    private static void distinct(List<Transaction> transactions) {
       transactions.stream().map(Transaction::type).distinct().forEach(System.out::println);
    }

    private static void skip() {
        List<Integer> numbers = new ArrayList<>(List.of(
                41, 75, 23, 89, 12, 54, 98, 6, 30, 67, 82, 19, 93, 4, 58, 71, 26, 95, 33, 49, 11, 78, 62, 5,
                87, 21, 99, 15, 73, 38, 52, 10, 84, 27, 60, 91, 44, 3, 55, 69, 17, 76, 90, 24, 8, 48, 81, 35, 63, 1, 57,
                72, 29, 96, 42, 65, 20, 88, 7, 51, 94, 18, 79, 46, 13, 61, 34, 80, 2, 50, 70, 25, 9, 45, 68, 14, 83, 39,
                53, 92, 28, 66, 16, 74, 32, 56, 97, 43, 77, 31, 64, 47, 59, 22, 100, 36, 85, 40, 6, 37
        ));

        numbers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(3).forEach(System.out::println);
    }

    private static void customReduce() {
        List<String> words =  new ArrayList<>(List.of(
                "Aardvark", "Bicycle", "Carpet", "Dolphin", "Elephant", "Fountain", "Guitar", "Hamburger",
                "Island", "Jungle", "Kangaroo", "Lighthouse", "Mountain", "Notebook", "Octopus", "Penguin", "Quasar",
                "Rainbow", "Satellite", "Telescope", "Umbrella", "Volcano", "Waterfall", "Xylophone", "Yacht", "Zebra",
                "Airplane", "Book", "Computer", "Dog", "Egg", "Frog", "Globe", "Hat", "Ice cream", "Jacket", "Kite",
                "Lemon", "Mouse", "Noodle", "Orange", "Pencil", "Queen", "Robot", "Star", "Tree", "Unicorn", "Violin",
                "Window", "Zucchini"));

        words.stream().reduce((a, b) -> a.length() > b.length() ? a : b)
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nothing"));
    }

    private static void bestSeller() {
        List<Book> books = new ArrayList<>(List.of(
                new Book(1, "aaaaa", 100.00, new ArrayList<>(
                        List.of(
                                BigDecimal.valueOf(530.00), BigDecimal.valueOf(200.00), BigDecimal.valueOf(155.50)))),
                new Book(2, "bbbbb", 55.00, new ArrayList<>(
                        List.of(BigDecimal.valueOf(55.00), BigDecimal.valueOf(220.00), BigDecimal.valueOf(1000.00),
                                BigDecimal.valueOf(300.00)))),
                new Book(3, "ccccc", 372.00, new ArrayList<>(
                        List.of(BigDecimal.valueOf(400.00), BigDecimal.valueOf(50.00), BigDecimal.valueOf(800.50),
                                BigDecimal.valueOf(10.00)))),
                new Book(4, "ddddd", 22.00, new ArrayList<>(
                        List.of(BigDecimal.valueOf(600.00)))),
                new Book(5, "eeeee", 87.00, new ArrayList<>(
                        List.of(BigDecimal.valueOf(3.50), BigDecimal.valueOf(5.00), BigDecimal.valueOf(1200.90)))),
                new Book(6, "fffff", 47.00, new ArrayList<>()),
                new Book(7, "ggggg", 99.00, new ArrayList<>(List.of(BigDecimal.valueOf(89.90)))),
                new Book(8, "hhhhh", 800.00, new ArrayList<>(
                        List.of(BigDecimal.valueOf(1050.10), BigDecimal.valueOf(23.50), BigDecimal.valueOf(67.40),
                                BigDecimal.valueOf(99.99)))),
                new Book(9, "iiiii", 243.00, new ArrayList<>(
                        List.of(BigDecimal.valueOf(5.00), BigDecimal.valueOf(10.00), BigDecimal.valueOf(30.00))))));

        books.stream().max(Comparator.comparingDouble(Book::value)).ifPresent(System.out::println);
        books.stream().max(Comparator.comparing(b ->
                b.sells().stream().max(BigDecimal::compareTo).orElse(BigDecimal.valueOf(0)))).ifPresent(System.out::println);
        books.stream().max(Comparator.comparingDouble(b ->
                b.sells().stream().mapToDouble(BigDecimal::doubleValue).sum())).ifPresent(System.out::println);

    }
 }
