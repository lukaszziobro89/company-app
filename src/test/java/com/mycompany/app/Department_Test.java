package com.mycompany.app;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;
import com.mycompany.exceptions.DifferentDepartmentTypeException;
import com.mycompany.exceptions.EmployeeAlreadyInEmployeesListException;
import com.mycompany.exceptions.JobAlreadyInListException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Department_Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

/**************************************
     Constructors tests
**************************************/

    @Test
    public void TEST_createDepartmentConstructor1(){
        Department department = new Department(DepartmentType.Construction);
        Department department1 = new Department(DepartmentType.IT);
        Department department2 = new Department(DepartmentType.Finance);

        assertEquals(10, department.getDepartmentId());
        assertEquals(20, department1.getDepartmentId());
        assertEquals(30, department2.getDepartmentId());
    }

    @Test
    public void TEST_createDepartmentConstructor2(){
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                Collections.singletonList("English"));

        Employee employee1 = new Employee(
                "FirstName1",
                "LastName1",
                32,
                6000,
                "mail1@mail.com",
                DepartmentType.IT_Helpdesk,
                Arrays.asList("English", "Spanish"));

        // TODO: change jobid if implementation changes
        Job job = new Job(10,"Title", 5000,7000,DepartmentType.Construction);
        Job job1 = new Job(20,"Title1", 5000,7000,DepartmentType.Construction);

        Department department = new Department(
                DepartmentType.Accounting,
                Collections.singletonList(job),
                Collections.singletonList(employee));

        Department department1 = new Department(
                DepartmentType.Shareholder_Services,
                Collections.singletonList(job1),
                Arrays.asList(employee, employee1));

        assertEquals(40, department.getDepartmentId());
        assertEquals(50, department1.getDepartmentId());
    }

/**************************************
     Add job to job list tests
**************************************/

    @Test
    public void TEST_addJobToJobList(){
        Job constructionJob = new Job(10,"Title", 5000,7000,DepartmentType.Construction);
        Job treasuryJob = new Job(20,"Title1", 5000,7000,DepartmentType.Treasury);

        Department constructionDepartment = new Department(DepartmentType.Construction);
        Department treasuryDepartment = new Department(DepartmentType.Treasury);

        constructionDepartment.addJobToJobList(constructionJob);
        treasuryDepartment.addJobToJobList(treasuryJob);

        assert constructionDepartment.getJobList().contains(constructionJob);
        assert treasuryDepartment.getJobList().contains(treasuryJob);
    }

    @Test
    public void TEST_throwJobAlreadyInListException(){
        Department constructionDepartment = new Department(DepartmentType.Construction);
        Job constructionJob = new Job(10, "construction",4000, 5000,DepartmentType.Construction);

        expectedException.expect(JobAlreadyInListException.class);
        expectedException.expectMessage("Job " + constructionJob + " already in jobs list for " + constructionDepartment.getDepartmentType() + " department.");

        constructionDepartment.addJobToJobList(constructionJob);
        constructionDepartment.addJobToJobList(constructionJob);
    }

    @Test
    public void TEST_throwDifferentDepartmentTypeException(){
        Department payrollDepartment = new Department(DepartmentType.Payroll);
        Job treasuryJob = new Job(10, "treasury", 4000,5000, DepartmentType.Treasury);
        expectedException.expect(DifferentDepartmentTypeException.class);
        expectedException.expectMessage("Attempt to add job to " + payrollDepartment.getDepartmentType() + " department, when job is assigned to " + treasuryJob.getDepartmentType() + " department");
        payrollDepartment.addJobToJobList(treasuryJob);
    }

/**************************************
 Add employee to employees list tests
**************************************/

    @Test
    public void TEST_addSingleEmployeeToEmployeesList(){
        Department payrollDepartment = new Department(DepartmentType.Payroll);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                Collections.singletonList("English"));
        payrollDepartment.addEmployeeToEmployeesList(employee);
    }

    @Test
    public void TEST_throwEmployeeAlreadyInEmployeesListException(){
        Department payrollDepartment = new Department(DepartmentType.Payroll);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                Collections.singletonList("English"));
        payrollDepartment.addEmployeeToEmployeesList(employee);

        assertTrue(payrollDepartment.getEmployeeList().contains(employee));
        expectedException.expect(EmployeeAlreadyInEmployeesListException.class);
        expectedException.expectMessage("Employee Employee{id=0, name='FirstName', " +
                "surname='LastName', age=33, salary=3000.0, email='mail@mail.com', " +
                "department=Executive, languages=[English]} is already in employees list.");
        payrollDepartment.addEmployeeToEmployeesList(employee);
    }

    @Test
    public void TEST_addListOfEmployeesToEmployeeList(){
        Department department = new Department(DepartmentType.Construction);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                Collections.singletonList("English"));

        Employee employee1 = new Employee(
                "FirstName1",
                "LastName1",
                34,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                Collections.singletonList("English"));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);

        department.addEmployeeToEmployeesList(employees);

        assertEquals(2, department.getEmployeeList().size());
    }

    @Test
    public void TEST_throwEmployeeAlreadyInEmployeesListExceptionAddListOfEmployeesToEmployeeList(){
        Department department = new Department(DepartmentType.Construction);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                Collections.singletonList("English"));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee);

        expectedException.expect(EmployeeAlreadyInEmployeesListException.class);
        expectedException.expectMessage("Employee Employee{id=0, name='FirstName', " +
                "surname='LastName', age=33, salary=3000.0, email='mail@mail.com', " +
                "department=Executive, languages=[English]} is already in employees list.");
        department.addEmployeeToEmployeesList(employees);
    }

}
