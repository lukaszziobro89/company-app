package com.mycompany.departments;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;

import java.util.List;

public class AccountingDepartment extends Department {
    public AccountingDepartment(DepartmentType departmentName, List<Job> jobList, List<Employee> employeesList) {
        super(departmentName, jobList, employeesList);
    }

    public AccountingDepartment(DepartmentType departmentName) {
        super(departmentName);
    }
}
