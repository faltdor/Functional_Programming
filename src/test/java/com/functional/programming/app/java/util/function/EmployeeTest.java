package com.functional.programming.app.java.util.function;

import com.functional.programming.app.function.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeTest {

    Collection<Employee> employees;

    /**
     * Represents a predicate (boolean-valued function) of one argument.
     * This is a functional interface whose functional method is test(Object).
     */
    Predicate<Employee> isSalaryBetweenFourAndSixThousand = employee -> (employee.getSalary() >= 4000 &&
                                                                   employee.getSalary() <= 6000);

    /**
     * Represents a function that accepts one argument and produces a result.
     * This is a functional interface whose functional method is apply(Object).
     */
    Function<Employee, String> byFirstName = Employee::getFirstName;
    Function<Employee, String> byLastName = Employee::getLastName;

    /**
     * A comparison function, which imposes a total ordering on some collection of objects. Comparators can be passed to
     * a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order. Comparators
     * can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to
     * provide an ordering for collections of objects that don't have a natural ordering.
     */
    Comparator<Employee> lastThenFirstComparator =
                    Comparator.comparing(byLastName).thenComparing(byFirstName);

    @Before
    public void setUp(){
        employees = new ArrayList<>();
        employees.add(new Employee("Jason", "Red", 7000, "IT"));
        employees.add(new Employee("Ashely", "Green", 10000, "IT"));
        employees.add(new Employee("Matthew", "Orange", 5060, "DV"));
        employees.add(new Employee("James", "Blue", 5700, "Sales"));
        employees.add(new Employee("Luke", "Yellow", 9000, "OP"));
        employees.add(new Employee("Jason", "Brown", 8000, "Marketing"));
        employees.add(new Employee("Wendy", "white", 3000, "Sales"));
    }

    @Test
    public void testEmployeesEarning4000To6000PerMonthSortedBySalary(){
        employees.stream()
                .filter(isSalaryBetweenFourAndSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
    }

    @Test
    public void testFirstEmployeeWhoEarns4000To6000PerMonth(){
           Employee employee = employees.stream()
                    .filter(isSalaryBetweenFourAndSixThousand)
                    .findFirst()
                    .get();
           System.out.printf("%n First Employee Who Earns 4000 To 6000 Per Month: %n%s%n", employee);
    }

    @Test
    public void testSortEmployeesByLastNameThenByFirstName() {
        employees.stream()
                .sorted(lastThenFirstComparator)
                .forEach(System.out::println);
    }

    @Test
    public void testSortEmployeesByLastNameThenByFirstNameDescendingOrder() {
        employees.stream()
                .sorted(lastThenFirstComparator.reversed())
                .forEach(System.out::println);
    }

    @Test
    public void testDisplayUniqueEmployeeLastNamesSorted() {
        employees.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted();
    }

    @Test
    public void testDisplayFullNameSorted() {
        employees.stream()
                .sorted(lastThenFirstComparator)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void testGroupEmployeesByDeparment() {
        Map<String, List<Employee>> groupedByDepartment =  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach((deparment, employeess) -> {
            System.out.println(deparment);
            employeess.forEach(employee -> System.out.printf("   %s%n", employee));
        });

    }

    @Test
    public void testCountEmployeesByDeparmentAscendingOrder() {
        Map<String, Long> countByDepartment =  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new, Collectors.counting()));

        countByDepartment.forEach((deparment, total) -> System.out.printf("%s has %d employee(s)%n", deparment, total));
    }

    @Test
    public void testCountEmployeesByDeparmentNotOrder() {
        Map<String, Long> countByDepartment =  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        countByDepartment.forEach((deparment, total) -> System.out.printf("%s has %d employee(s)%n", deparment, total));
    }
}
