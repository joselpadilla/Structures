package com.challenges.misc;

import java.util.*;
import java.util.stream.*;

public class StreamSlidingWindow {

    public static <T> Stream<List<T>> slidingWindow(List<T> list, int windowSize) {
        if (windowSize <= 0) {
            throw new IllegalArgumentException("Window size must be positive");
        }

        return IntStream.range(0, list.size() - windowSize + 1)
                .parallel()
                .mapToObj(i -> list.subList(i, i + windowSize));
    }

    // Example usage: Find all sublists of size 3 with sum greater than threshold
    public static List<List<Integer>> findSubarraysAboveThreshold(
            List<Integer> numbers, int windowSize, int threshold) {

        return slidingWindow(numbers, windowSize)
                .filter(window -> window.stream()
                        .mapToInt(Integer::intValue)
                        .sum() > threshold)
                .collect(Collectors.toList());
    }

    // Moving average using streams
    public static List<Double> movingAverage(List<Double> data, int windowSize) {
        return IntStream.range(0, data.size() - windowSize + 1)
                .mapToObj(i -> data.subList(i, i + windowSize))
                .map(window -> window.stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(0.0))
                .collect(Collectors.toList());
    }

    public static <T> List<List<T>> getAllSubarrays(List<T> inputList) {
        if (inputList == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        return IntStream.range(0, inputList.size())
                .parallel()
                .boxed()
                .flatMap(start ->
                        IntStream.rangeClosed(start + 1, inputList.size())
                                .mapToObj(end -> inputList.subList(start, end))
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

/*
        findSubarraysAboveThreshold(new ArrayList<>(List.of(20, 10, 15, 55, 30, 99, 120, 200, 100)),
                3, 50).forEach(System.out::println);
*/
/*
        System.out.printf("Subarrays of size %d: %d%n", 5, slidingWindow(new ArrayList<>(List.of(20, 10, 15, 55, 30, 99, 120, 200, 100)),
                5).count());

        slidingWindow(new ArrayList<>(List.of(20, 10, 15, 55, 30, 99, 120, 200, 100)),
                5).forEach(System.out::println);

        System.out.println("___________________________________________");
        System.out.printf("Subarrays: %d%n", getAllSubarrays(new ArrayList<>(List.of(20, 10, 15, 55, 30, 99, 120, 200, 100)))
                .stream().count());
*/

//        getAllSubarrays(new ArrayList<>(List.of(1, 2, 3, 7, 5)))
//                .stream()
//                .filter(sub -> sub.stream().mapToInt(Integer::intValue).sum() == 12)
//                .findFirst()
//                .ifPresent(System.out::println);

 /*       IntStream.range(0, List.of(1, 2, 3, 7, 5).size())
                .parallel()
                .boxed()
                .flatMap(start ->
                        IntStream.rangeClosed(start + 1, List.of(1, 2, 3, 7, 5).size())
                                .boxed()
                                .map(end -> List.of(start, end))
                                .filter(list -> List.of(1, 2, 3, 7, 5).subList(list.get(0), list.getLast()).stream()
                                        .mapToInt(Integer::intValue).sum() == 12)
                )
                .collect(Collectors.toList())
                .forEach(System.out::println);
*/
        System.out.println(IntStream.range(0, List.of(1, 2, 3, 7, 5).size())
                .parallel()
                .boxed()
                .flatMap(start ->
                        IntStream.rangeClosed(start + 1, List.of(1, 2, 3, 7, 5).size())
                                .mapToObj(end -> List.of(start + 1, end))
                                .filter(list -> List.of(1, 2, 3, 7, 5).subList(list.getFirst() - 1, list.getLast())
                                        .stream().mapToInt(Integer::intValue).sum() == 12)
                )
                .findFirst()
                .orElse(Collections.singletonList(-1)));
    }

}
