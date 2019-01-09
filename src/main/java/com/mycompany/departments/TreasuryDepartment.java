package com.mycompany.departments;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;

import java.util.List;

public class TreasuryDepartment extends Department {

    public TreasuryDepartment(DepartmentType departmentName, List<Job> jobList, List<Employee> employeesList) {
        super(departmentName, jobList, employeesList);
    }

    public TreasuryDepartment(DepartmentType departmentName) {
        super(departmentName);
    }
}
