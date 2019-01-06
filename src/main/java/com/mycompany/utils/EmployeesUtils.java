package com.mycompany.utils;

import com.mycompany.entity.Department;
import com.mycompany.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeesUtils {

    public List<String> getAllLanguagesEmployeesSpeakFromDepartment(Department department){
        return department.getEmployeeList().stream()
                .map(employee -> employee.getLanguages().stream())
                    .flatMap(Stream::sorted)
                        .distinct()
                            .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesBetweenAge(Department department, int higherThen, int lessThen){
        return department.getEmployeeList().stream()
                .filter(employee -> employee.getAge() > higherThen && employee.getAge() < lessThen)
                .collect(Collectors.toList());
    }

    public long countEmployeesWithLanguage(Department department, String language){
        return department.getEmployeeList().stream()
                .map(user -> user.getLanguages().stream())
                .flatMap(languageStream -> languageStream
                        .map(String::toLowerCase)
                        .filter(lan -> lan.equals(language.toLowerCase())))
                .count();
    }

    public List<Employee> getEmployeesWithLanguage(Department department, String language){
        return department.getEmployeeList().stream()
                .filter(emp -> emp.getLanguages().contains(language))
                .collect(Collectors.toList());
    }
}
