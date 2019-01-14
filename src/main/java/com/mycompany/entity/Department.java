package com.mycompany.entity;

import com.mycompany.exceptions.DifferentDepartmentTypeException;
import com.mycompany.exceptions.EmployeeAlreadyInEmployeesListException;
import com.mycompany.exceptions.JobAlreadyInListException;

import java.util.ArrayList;
import java.util.List;

public abstract class Department {
    private static int ID = 10;
    private int departmentId;
    private DepartmentType departmentType;
    private List<Job> jobList = new ArrayList<>();
    private List<Employee> employeesList = new ArrayList<>();

    public Department(DepartmentType departmentName, List<Job> jobs, List<Employee> employeesList) {
        this.departmentId = ID;
        ID += 10;
        this.departmentType = departmentName;

            List<Job> jobsConstructor = new ArrayList<>();
            for (Job job : jobs) {
                if(this.departmentType.equals(job.getDepartmentType())){
                    jobsConstructor.add(job);
                } else{
                    throw new DifferentDepartmentTypeException("Job department: " + job.getDepartmentType()
                            + " is different then department type: " + departmentType);
                }
                this.jobList = jobsConstructor;
            }
        this.employeesList = employeesList;
    }

    public Department(DepartmentType departmentName) {
        this.departmentId = ID;
        ID += 10;
        this.departmentType = departmentName;
    }

    public Department(int departmentId, DepartmentType departmentType, List<Job> jobs) {
        this.departmentId = departmentId;
        this.departmentType = departmentType;

        List<Job> jobsConstructor = new ArrayList<>();
            for (Job job : jobs) {
                if (this.departmentType.equals(job.getDepartmentType())) {
                    jobsConstructor.add(job);
                } else {
                    throw new DifferentDepartmentTypeException("Job department: " + job.getDepartmentType()
                            + " is different then department type: " + departmentType);
                }
                this.jobList = jobsConstructor;
            }
    }

    public void addJobToJobList(Job job) throws JobAlreadyInListException, DifferentDepartmentTypeException{
        if (jobList.contains(job)){
            throw new JobAlreadyInListException
                    ("Job " + job + " already in jobs list for " + this.departmentType + " department.");
        } else {
            if (!(job.getDepartmentType().equals(this.departmentType))){
                throw new DifferentDepartmentTypeException
                        ("Attempt to add job to " + this.departmentType + " department, when job is assigned to " + job.getDepartmentType() + " department");
            } else{
                jobList.add(job);
            }
        }
    }

    public void addEmployeeToEmployeesList(Employee employee) throws EmployeeAlreadyInEmployeesListException {
        if(employeesList.contains(employee)){
            throw new EmployeeAlreadyInEmployeesListException("Employee " + employee.toString() + " is already in employees list.");
        }else {
            employeesList.add(employee);
        }
    }

    public void addEmployeeToEmployeesList(List<Employee> employees) throws EmployeeAlreadyInEmployeesListException {
        for(Employee employee : employees){
            if(employeesList.contains(employee)){
                throw new EmployeeAlreadyInEmployeesListException("Employee " + employee.toString() + " is already in employees list.");
            }else {
                employeesList.add(employee);
            }
        }
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

    public void setJobList(List<Job> jobs) {
        List<Job> jobsConstructor = new ArrayList<>();
        for (Job job : jobs) {
            if(this.departmentType.equals(job.getDepartmentType())){
                jobsConstructor.add(job);
            } else{
                throw new DifferentDepartmentTypeException("Job department: " + job.getDepartmentType()
                        + " is different then department type: " + departmentType);
            }
            this.jobList = jobsConstructor;
        }
    }

    public List<Employee> getEmployeeList() {
        return employeesList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeesList = employeeList;
    }
}
