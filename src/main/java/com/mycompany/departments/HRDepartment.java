package com.mycompany.departments;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;

import java.util.List;

public class HRDepartment extends Department {

    public HRDepartment(DepartmentType departmentName, List<Job> jobList, List<Employee> employeesList) {
        super(departmentName, jobList, employeesList);
    }

    public HRDepartment(DepartmentType departmentName) {
        super(departmentName);
    }

    public void createHrReportForDepartment(Department department){
        // TODO: create HR report for department
    }
}
