package com.mycompany.entity;

import com.mycompany.exceptions.AgeException;
import com.mycompany.exceptions.ChangeSalaryException;
import com.mycompany.exceptions.SalaryException;

import java.util.List;

public class Employee{
    private int id;
    private String name;
    private String surname;
    private int age;
    private double salary;
    private String email;
    private DepartmentType department;
    private List<String> languages;

    private static int totalEmployeesCounter = 0;

    public Employee(
            String name,
            String surname,
            int age,
            double salary,
            String email,
            DepartmentType department,
            List<String> languages) throws AgeException, SalaryException {
        this.id = id++;
        this.name = name;
        this.surname = surname;
        // TODO: add exception when min/max salary not in global job min/max
            if (age > 0) {
                this.age = age;
            } else {
                throw new AgeException("Age cannot be negative or zero.");
            }
            if (salary > 0) {
                this.salary = salary;
            } else {
                    throw new SalaryException("Salary cannot be negative.");
            }
        this.email = email;
        this.department = department;
        this.languages = languages;
        totalEmployeesCounter++;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", languages=" + languages +
                '}';
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentType department) {
        this.department = department;
    }

    // TODO: add exception to not exceed max salary
    public void increaseSalary(double raiseAmount){
        if (raiseAmount > 0) {
            salary += raiseAmount;
        } else {
            throw new ChangeSalaryException("Raise amount must be greater then 0.");
        }
    }

    // TODO: add exception to not exceed min salary
    public void decreaseSalary(double decreaseAmount){
        if (decreaseAmount > 0){
            salary -= decreaseAmount;
        } else {
            throw new ChangeSalaryException("Decrease amount must be greater then 0.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException{
        if (age > 0) {
            this.age = age;
        } else {
            throw new AgeException("Age cannot be negative or zero.");
        }
    }

    public double getSalary() {
        return salary;
    }

    // TODO: add exceptions to not exceed min and max salary
    public void setSalary(double salary) throws SalaryException{
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new SalaryException("Salary cannot be negative.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static int getTotalEmployeesCounter() {
        return totalEmployeesCounter;
    }
}
