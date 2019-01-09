package com.mycompany.departments;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;

import java.util.List;

public class FinanceDepartment extends Department {
    public FinanceDepartment(DepartmentType departmentName, List<Job> jobList, List<Employee> employeesList) {
        super(departmentName, jobList, employeesList);
    }

    public FinanceDepartment(DepartmentType departmentName) {
        super(departmentName);
    }
}
