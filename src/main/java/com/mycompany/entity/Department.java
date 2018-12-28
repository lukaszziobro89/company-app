package com.mycompany.entity;

import com.mycompany.exceptions.DifferentDepartmentTypeException;
import com.mycompany.exceptions.EmployeeAlreadyInEmployeesListException;
import com.mycompany.exceptions.JobAlreadyInListException;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private static int ID = 10;
    private int departmentId;
    private DepartmentType departmentType;
    private List<Job> jobList = new ArrayList<>();
    private List<Employee> employeesList = new ArrayList<>();

    public Department(DepartmentType departmentName, List<Job> jobList, List<Employee> employeesList) {
        this.departmentId = ID;
        ID += 10;
        this.departmentType = departmentName;
        this.jobList = jobList;
        this.employeesList = employeesList;
    }

    public Department(DepartmentType departmentName) {
        this.departmentId = ID;
        ID += 10;
        this.departmentType = departmentName;
    }

    public void addJobToJobList(Job job) throws JobAlreadyInListException, DifferentDepartmentTypeException{
        if (jobList.contains(job)){
            throw new JobAlreadyInListException
                    ("Job " + job + "already in jobs list for " + this.departmentType + " department.");
        } else {
            if (!(job.getDepartmentType().equals(this.departmentType))){
                throw new DifferentDepartmentTypeException
                        ("Attempt to add job to " + this.departmentType + " department, when job is assigned to " + job.getDepartmentType() + "department");
            } else{
                jobList.add(job);
            }
        }
    }

    public void addEmployeeToEmployeesList(Employee employee) throws EmployeeAlreadyInEmployeesListException {
        // TODO: add implementation of adding single employee to employees list
    }

    public void addEmployeeToEmployeesList(List<Employee> employeesList) throws EmployeeAlreadyInEmployeesListException {
        // TODO: add implementation of adding list of employees to employees list
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<Employee> getEmployeeList() {
        return employeesList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeesList = employeeList;
    }
}
