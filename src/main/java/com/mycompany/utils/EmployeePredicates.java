package com.mycompany.utils;

import com.mycompany.entity.Employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

    public static List<Employee> filterEmployees(List<Employee> employeeList, Predicate<Employee> predicate){
        return employeeList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static Predicate<Employee> isAgeMoreThen(Integer age){
        return emp -> emp.getAge() > age;
    }

    public static Predicate<Employee> isBeforeAgeAndSalaryUnder(int age, int salary){
        Predicate<Employee> isBeforeAge = employee -> employee.getAge() < age;
        Predicate<Employee> salaryUnder = employee -> employee.getSalary() < salary;
        return isBeforeAge.and(salaryUnder);
    }

    public static Predicate<Employee> isBeforeAgeAndSalaryOver(int age, int salary){
        Predicate<Employee> isBeforeAge = employee -> employee.getAge() < age;
        Predicate<Employee> salaryOver = employee -> employee.getSalary() > salary;
        return isBeforeAge.and(salaryOver);
    }

    public static Predicate<Employee> isOverAgeAndSalaryUnder(int age, int salary){
        Predicate<Employee> isOverAge = employee -> employee.getAge() > age;
        Predicate<Employee> salaryUnder = employee -> employee.getSalary() < salary;
        return isOverAge.and(salaryUnder);
    }

    public static Predicate<Employee> isOverAgeAndSalaryOver(int age, int salary){
        Predicate<Employee> isOverAge = employee -> employee.getAge() > age;
        Predicate<Employee> salaryOver = employee -> employee.getSalary() > salary;
        return isOverAge.and(salaryOver);
    }

    public static Predicate<Employee> isBetweenAges(int lowerAge, int greaterAge){
        Predicate<Employee> isOverAge = employee -> employee.getAge() > lowerAge;
        Predicate<Employee> isUnderAge = employee -> employee.getAge() < greaterAge;
        return isOverAge.and(isUnderAge);
    }

    public static Predicate<Employee> hasSalaryUnder(int salary){
        return employee -> employee.getSalary() < salary;
    }

    public static Predicate<Employee> hasSalaryOver(int salary){
        return employee -> employee.getSalary() > salary;
    }

//    public static Predicate<Employee> haveSalariesBetween(int lowerSalary, int upperSalary){
//
//    }
}
