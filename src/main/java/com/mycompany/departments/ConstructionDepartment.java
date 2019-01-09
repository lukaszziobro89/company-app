package com.mycompany.departments;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;

import java.util.List;

public class ConstructionDepartment extends Department {
    public ConstructionDepartment(DepartmentType departmentName, List<Job> jobList, List<Employee> employeesList) {
        super(departmentName, jobList, employeesList);
    }

    public ConstructionDepartment(DepartmentType departmentName) {
        super(departmentName);
    }
}
