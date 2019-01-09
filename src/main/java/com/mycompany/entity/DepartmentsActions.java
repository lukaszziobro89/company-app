package com.mycompany.entity;

import java.util.List;

public interface DepartmentsActions {
    void addJobToJobList(Job job);
    void addEmployeeToEmployeesList(Employee employee);
    void addEmployeeToEmployeesList(List<Employee> employees);
}
