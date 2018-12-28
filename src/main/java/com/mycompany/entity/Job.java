package com.mycompany.entity;

public class Job {
    private int jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;
    private DepartmentType departmentType;

    private static final double globalMinSalary = 3000;
    private static final double globalMaxSalary = 20000;

    public Job(int jobId, String jobTitle, double minSalary, double maxSalary, DepartmentType departmentType) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        // TODO: add exception for global salary values
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        // TODO: constructor - assure that department is from proper list
        //TODO: exception when max salary < min salary
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
