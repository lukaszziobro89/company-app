package com.mycompany.entity;

import com.mycompany.exceptions.NegativeSalaryException;
import com.mycompany.exceptions.SalaryNotInRangeException;

public class Job {
    private int jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;
    private DepartmentType departmentType;

    public static final double globalMinSalary = 3000;
    public static final double globalMaxSalary = 20000;

    public Job(int jobId, String jobTitle, double minSalary, double maxSalary, DepartmentType departmentType) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;

        if (minSalary < 0) {
                throw new NegativeSalaryException("Salary cannot be negative.");
            } else if(minSalary > Job.globalMaxSalary){
                throw new SalaryNotInRangeException("Salary " + minSalary + " exceeds global max salary: " + Job.globalMaxSalary);
            } else if(minSalary < Job.globalMinSalary){
                throw new SalaryNotInRangeException("Salary " + minSalary + " is under global min salary: " + Job.globalMinSalary);
            }else {
                this.minSalary= minSalary;
            }

            if (maxSalary < 0) {
                throw new NegativeSalaryException("Salary cannot be negative.");
            } else if(maxSalary > Job.globalMaxSalary){
                throw new SalaryNotInRangeException("Salary " + maxSalary + " exceeds global max salary: " + Job.globalMaxSalary);
            } else if(minSalary < Job.globalMinSalary){
                throw new SalaryNotInRangeException("Salary " + maxSalary + " is under global min salary: " + Job.globalMinSalary);
            }else if(maxSalary < minSalary){
                throw new SalaryNotInRangeException("Max salary " + maxSalary + " is lower then min salary " + minSalary);
            }else{
                this.maxSalary= maxSalary;
            }

        this.departmentType = departmentType;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        // TODO: add implementation using globalMinSalary
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        // TODO: add implementation using globalMinSalary
        this.maxSalary = maxSalary;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        // TODO: setter - assure that department is from proper list
        this.departmentType = departmentType;
    }
}
