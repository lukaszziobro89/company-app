package com.mycompany.app;

import com.mycompany.departments.*;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Department_Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Job manager = new Job(20,"Manager", 8000,15000, DepartmentType.Executive);
    private Job itHelpdesk = new Job(20,"IT Helpdesk", 8000,15000, DepartmentType.IT_Helpdesk);

/**************************************
     Constructors tests
**************************************/

    @Test
    public void TEST_createDepartmentConstructor1(){
        Department department = new ConstructionDepartment(DepartmentType.Construction);
        Department department1 = new ITDepartment(DepartmentType.IT);
        Department department2 = new FinanceDepartment(DepartmentType.Finance);

        assertEquals(DepartmentType.Construction, department.getDepartmentType());
        assertEquals(DepartmentType.IT, department1.getDepartmentType());
        assertEquals(DepartmentType.Finance, department2.getDepartmentType());
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
                manager,
                Collections.singletonList("English"));

        Employee employee1 = new Employee(
                "FirstName1",
                "LastName1",
                32,
                6000,
                "mail1@mail.com",
                DepartmentType.IT_Helpdesk,
                itHelpdesk,
                Arrays.asList("English", "Spanish"));

        Job job = new Job(10,"Title", 5000,7000,DepartmentType.Accounting);
        Job job1 = new Job(20,"Title1", 5000,7000,DepartmentType.Finance);

        Department department = new AccountingDepartment(
                DepartmentType.Accounting,
                Collections.singletonList(job),
                Collections.singletonList(employee));

        Department department1 = new FinanceDepartment(
                DepartmentType.Finance,
                Collections.singletonList(job1),
                Arrays.asList(employee, employee1));

        assertEquals(DepartmentType.Accounting, department.getDepartmentType());
        assertEquals(DepartmentType.Finance, department1.getDepartmentType());
    }

    @Test
    public void TEST_throwDifferentDepartmentTypeExceptionInConstructor1(){
        expectedException.expect(DifferentDepartmentTypeException.class);
        expectedException.expectMessage("Job department: IT_Helpdesk is different then department type: Finance");
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                manager,
                Collections.singletonList("English"));
        Job itHelpdesk = new Job(20,"IT Helpdesk", 8000,15000, DepartmentType.IT_Helpdesk);
        Department department2 = new FinanceDepartment(DepartmentType.Finance, Collections.singletonList(itHelpdesk), Collections.singletonList(employee));

    }

/**************************************
     Add job to job list tests
**************************************/

    @Test
    public void TEST_addJobToJobList(){
        Job constructionJob = new Job(10,"Title", 5000,7000,DepartmentType.Construction);
        Job treasuryJob = new Job(20,"Title1", 5000,7000,DepartmentType.Treasury);

        Department constructionDepartment = new ConstructionDepartment(DepartmentType.Construction);
        Department treasuryDepartment = new TreasuryDepartment(DepartmentType.Treasury);

        constructionDepartment.addJobToJobList(constructionJob);
        treasuryDepartment.addJobToJobList(treasuryJob);

        assert constructionDepartment.getJobList().contains(constructionJob);
        assert treasuryDepartment.getJobList().contains(treasuryJob);
    }

    @Test
    public void TEST_throwJobAlreadyInListException(){
        Department constructionDepartment = new ConstructionDepartment(DepartmentType.Construction);
        Job constructionJob = new Job(10, "construction",4000, 5000,DepartmentType.Construction);

        expectedException.expect(JobAlreadyInListException.class);
        expectedException.expectMessage("Job " + constructionJob + " already in jobs list for " + constructionDepartment.getDepartmentType() + " department.");

        constructionDepartment.addJobToJobList(constructionJob);
        constructionDepartment.addJobToJobList(constructionJob);
    }

    @Test
    public void TEST_throwDifferentDepartmentTypeException(){
        Department payrollDepartment = new FinanceDepartment(DepartmentType.Finance);
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
        Department payrollDepartment = new FinanceDepartment(DepartmentType.Payroll);
        Job payrollJob = new Job(40,"Payroll Manager", 5000, 7000, DepartmentType.Payroll);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Payroll,
                payrollJob,
                Collections.singletonList("English"));
        payrollDepartment.addEmployeeToEmployeesList(employee);
    }

    @Test
    public void TEST_throwEmployeeAlreadyInEmployeesListException(){
        Department treasuryDepartment = new TreasuryDepartment(DepartmentType.Treasury);
        Job treasuryManager = new Job(20,"Treasury Manager", 5000, 7000, DepartmentType.Treasury);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Treasury,
                treasuryManager,
                Collections.singletonList("English"));
        treasuryDepartment.addEmployeeToEmployeesList(employee);

        assertTrue(treasuryDepartment.getEmployeeList().contains(employee));
        expectedException.expect(EmployeeAlreadyInEmployeesListException.class);
        expectedException.expectMessage("Employee Employee{id=0, name='FirstName', " +
                "surname='LastName', age=33, salary=3000.0, email='mail@mail.com', " +
                "department=Treasury, job=Treasury Manager, languages=[English]} is already in employees list.");
        treasuryDepartment.addEmployeeToEmployeesList(employee);
    }

    @Test
    public void TEST_addListOfEmployeesToEmployeeList(){
        Department department = new ConstructionDepartment(DepartmentType.Construction);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                manager,
                Collections.singletonList("English"));

        Employee employee1 = new Employee(
                "FirstName1",
                "LastName1",
                34,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                manager,
                Collections.singletonList("English"));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);

        department.addEmployeeToEmployeesList(employees);

        assertEquals(2, department.getEmployeeList().size());
    }

    @Test
    public void TEST_throwEmployeeAlreadyInEmployeesListExceptionAddListOfEmployeesToEmployeeList(){
        Department department = new ConstructionDepartment(DepartmentType.Construction);
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                33,
                3000,
                "mail@mail.com",
                DepartmentType.Executive,
                manager,
                Collections.singletonList("English"));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee);

        expectedException.expect(EmployeeAlreadyInEmployeesListException.class);
        expectedException.expectMessage("Employee Employee{id=0, name='FirstName', " +
                "surname='LastName', age=33, salary=3000.0, email='mail@mail.com', " +
                "department=Executive, job=Manager, languages=[English]} is already in employees list.");
        department.addEmployeeToEmployeesList(employees);
    }

/**************************************
Add employee to employees list tests
**************************************/

    @Test
    public void TEST_setJobList(){
        Job javaDeveloper = new Job(20,"Java Developer", 10000,15000, DepartmentType.IT);
        Job phpDeveloper = new Job(30,"PHP Developer", 10000,15000, DepartmentType.IT);
        Department itDepartment = new ITDepartment(DepartmentType.IT);
        itDepartment.setJobList(Arrays.asList(javaDeveloper, phpDeveloper));
    }

    @Test
    public void TEST_throwDifferentDepartmentTypeExceptionInSetJobList(){
        Department itDepartment = new ITDepartment(DepartmentType.IT);
        Job javaDeveloper = new Job(20,"Java Developer", 10000,15000, DepartmentType.IT);
        Job financeManager = new Job(30,"Finance manager", 10000,15000, DepartmentType.Finance);
        List<Job> jobs = Arrays.asList(javaDeveloper,financeManager);
        expectedException.expect(DifferentDepartmentTypeException.class);
        expectedException.expectMessage("Job department: Finance is different then department type: IT");
        itDepartment.setJobList(Arrays.asList(javaDeveloper, financeManager));
    }


}
