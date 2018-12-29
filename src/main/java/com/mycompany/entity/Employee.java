package com.mycompany.entity;

import com.mycompany.exceptions.AgeException;
import com.mycompany.exceptions.NegativeSalaryException;
import com.mycompany.exceptions.SalaryNotInRangeException;

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
            List<String> languages) throws AgeException, NegativeSalaryException {
        this.id = id++;
        this.name = name;
        this.surname = surname;

            if (age > 0) {
                this.age = age;
            } else {
                throw new AgeException("Age cannot be negative or zero.");
            }

            if (salary < 0) {
                throw new NegativeSalaryException("Salary cannot be negative.");
            } else if(salary > Job.globalMaxSalary){
                throw new SalaryNotInRangeException("Salary " + salary + " exceeds global max salary: " + Job.globalMaxSalary);
            } else if(salary < Job.globalMinSalary){
                throw new SalaryNotInRangeException("Salary " + salary + " is under global min salary: " + Job.globalMinSalary);
            }else {
                this.salary = salary;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (department != employee.department) return false;
        return languages != null ? languages.equals(employee.languages) : employee.languages == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        return result;
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

    public void increaseSalary(double raiseAmount){
        if (raiseAmount < 0 ) {
            throw new NegativeSalaryException("Raise amount must be greater then 0.");
        } else if (this.salary + raiseAmount >= Job.globalMaxSalary){
            throw new SalaryNotInRangeException("Raising salary: " + this.salary + " + " + raiseAmount + " = " + (this.salary + raiseAmount) +
                    " exceeds global company max salary " + Job.globalMaxSalary);
        }else {
            salary += raiseAmount;
        }
    }

    public void decreaseSalary(double decreaseAmount){
        if (decreaseAmount < 0){
            throw new NegativeSalaryException("Decrease amount must be greater then 0.");
        } else if(this.salary - decreaseAmount <= Job.globalMinSalary){
            throw new SalaryNotInRangeException("Decreasing salary: " + this.salary + " - " + decreaseAmount + " = " + (this.salary - decreaseAmount) +
                    " is under global company min salary " + Job.globalMinSalary);
        } else{
            salary -= decreaseAmount;
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

    public void setSalary(double salary) throws NegativeSalaryException {
        if (salary < 0) {
            throw new NegativeSalaryException("Salary cannot be negative.");
        } else if(salary > Job.globalMaxSalary){
            throw new SalaryNotInRangeException("Salary " + salary + " exceeds global max salary: " + Job.globalMaxSalary);
        } else if(salary < Job.globalMinSalary){
            throw new SalaryNotInRangeException("Salary " + salary + " is under global min salary: " + Job.globalMinSalary);
        }else {
            this.salary = salary;
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
