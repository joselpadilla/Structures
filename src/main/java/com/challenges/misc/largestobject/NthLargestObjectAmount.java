package com.challenges.misc.largestobject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NthLargestObjectAmount {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Alex", 10000);
        Employee employee2 = new Employee(2, "Bob", 40000);
        Employee employee3 = new Employee(3, "John", 30000);
        Employee employee4 = new Employee(4, "Jeff", 20000);

        List<Employee> employees = Arrays.asList(employee, employee2, employee3, employee4);

        System.out.println("Employee with largest salary = "
                + nthLargestObjectAmount(4, employees).name());
    }

    private static Employee nthLargestObjectAmount(int k, List<Employee> items) {

        return items.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .skip(k - 1)
                .findFirst()
                .orElse(null);
    }
}
