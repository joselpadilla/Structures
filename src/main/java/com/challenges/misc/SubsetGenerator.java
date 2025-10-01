package com.challenges.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubsetGenerator {
    public static void main(String[] args) {
        // Example usage
        List<Integer> nums = List.of(1, 7, 2, 4);
/*
        List<List<Integer>> subsets = getSubsetsBacktracking(nums);
        System.out.println(subsets);
*/
        findValidCombinations( 4, nums);
        //System.out.printf("length %d%n", maxNonDivisibleSubsetWithMap(nums, 3));
    }

    public static List<List<Integer>> getSubsetsBacktracking(List<Integer> nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        generateSubsets(nums, 0, currentSubset, allSubsets);
        return allSubsets;
    }

    private static void generateSubsets(List<Integer> nums, int index,
                                        List<Integer> currentSubset,
                                        List<List<Integer>> allSubsets) {
        // Base case: If all elements have been processed, add the current subset
        if (index == nums.size()) {
            allSubsets.add(new ArrayList<>(currentSubset)); // Add a copy to avoid modification issues
            return;
        }

        // Option 1: Include the current element
        currentSubset.add(nums.get(index));
        generateSubsets(nums, index + 1, currentSubset, allSubsets);
        currentSubset.remove(currentSubset.size() - 1); // Backtrack: remove the element

        // Option 2: Exclude the current element
        generateSubsets(nums, index + 1, currentSubset, allSubsets);
    }
    public static void findValidCombinations(int k, List<Integer> s) {
        System.out.println(1 << s.size());
         System.out.println(IntStream.range(0, 1 << s.size())
                .parallel() // Use parallel processing for large lists
                .mapToObj(mask ->
                        new ArrayList<Integer>(IntStream.range(0, s.size())
                                .filter(i -> (mask & (1 << i)) != 0)
                                .mapToObj(s::get)
                                .sorted()
                                .collect(Collectors.toCollection(TreeSet::new)))
                )

                .filter(subset -> !subset.isEmpty() && subset.size() > 1)
                 .filter(stream -> IntStream.range(0, stream.size())
                         .flatMap(i -> IntStream.range(i + 1, stream.size())
                                 .map(j -> stream.get(i) + stream.get(j)))
                         .boxed() // Convert IntStream to Stream<Integer>
                         .collect(Collectors.toSet()).stream().allMatch(n -> n % k != 0))
                 .collect(Collectors.toSet()).stream().map(List::size).max(Integer::compareTo).orElse(0));
                //.mapToInt(Integer::intValue).sum() == targetSum)
                    //.mapToInt(List::size)
                //.max();

        System.out.println("________________________________________________________");
/*
        subsets.stream().map(s->
                IntStream.range(0, s.size())
                        .boxed()
                .map(i -> IntStream.range(i + 1, s.size()).boxed() // Start inner loop from i+1 to avoid duplicates
                        .map(j -> s.get(i) + s.get(j))).toList()) // Sum the pair
                .collect(Collectors.toList()).forEach(System.out::println); // Collect the sums into a s
*/
        System.out.println(IntStream.range(0, s.size())
                .flatMap(i -> IntStream.range(i + 1, s.size())
                        .map(j -> s.get(i) + s.get(j)))
                .boxed() // Convert IntStream to Stream<Integer>
                .collect(Collectors.toSet()).stream().allMatch(n -> n % 3 != 0));
        ; // Collect distinct sums into a Set


    }
    public static int maxNonDivisibleSubsetWithMap(List<Integer> s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Use a map to count remainders
        Map<Integer, Integer> remainderCount = new HashMap<>();

        for (int num : s) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k;
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        int result = 0;

        // Handle remainder 0
        if (remainderCount.containsKey(0) && remainderCount.get(0) > 0) {
            result++;
        }

        // Handle middle case for even k
        if (k % 2 == 0 && remainderCount.containsKey(k / 2) && remainderCount.get(k / 2) > 0) {
            result++;
        }

        // Handle complementary pairs
        for (int i = 1; i < (k + 1) / 2; i++) {
            int complement = k - i;
            int count1 = remainderCount.getOrDefault(i, 0);
            int count2 = remainderCount.getOrDefault(complement, 0);
            result += Math.max(count1, count2);
        }

        return result;
    }
}