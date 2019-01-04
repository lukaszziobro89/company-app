package com.mycompany.utils;

import com.mycompany.entity.Department;
import com.mycompany.entity.Employee;

public class DepartmentsUtils {

    public double countAverageSalaryForDepartment(Department department){
        return department.getEmployeeList().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(Double.NaN);
    }

    public double sumSalariesForDepartment(Department department){
        return department.getEmployeeList().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
