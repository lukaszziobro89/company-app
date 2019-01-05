package com.mycompany.utils;

import com.mycompany.entity.Department;

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
}
