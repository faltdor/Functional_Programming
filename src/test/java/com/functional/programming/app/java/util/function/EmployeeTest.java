package com.functional.programming.app.java.util.function;

import com.functional.programming.app.function.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;

public class EmployeeTest {

    Collection<Employee> employees;

    Predicate<Employee> isSalaryBetweenFourAndSixThousand = employee -> (employee.getSalary() >= 4000 &&
                                                                   employee.getSalary() <= 6000);


    @Before
    public void setUp(){
        employees = new ArrayList<>();
        employees.add(new Employee("Jason", "Red", 4600, "IT"));
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
           System.out.println("%n First Employee Who Earns 4000 To 6000 Per Month: " + employee.toString());
    }
}
