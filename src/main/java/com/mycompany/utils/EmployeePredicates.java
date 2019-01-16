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


}
