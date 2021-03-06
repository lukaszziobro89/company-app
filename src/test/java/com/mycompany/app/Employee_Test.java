package com.mycompany.app;

import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;
import com.mycompany.exceptions.AgeException;
import com.mycompany.exceptions.DifferentDepartmentTypeException;
import com.mycompany.exceptions.NegativeSalaryException;
import com.mycompany.exceptions.SalaryNotInRangeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class Employee_Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Job itDirector = new Job(10, "Director", 10000,20000, DepartmentType.IT);
    private Job executive = new Job(10, "Executive", 10000,20000, DepartmentType.Executive);

    private Employee employeeTester = new Employee(
            "FirstName",
            "LastName",
            25,
            5000,
            "email@email.com",
            DepartmentType.Executive,
            executive,
            Arrays.asList("English", "Spanish")
    );

/**************************************
     Constructors tests
**************************************/

    @Test
    public void TEST_createEmployee(){
            Employee employee = new Employee(
                    "TestName",
                    "TestSurname",
                    23,
                    4000,
                    "mail@mail.com",
                    DepartmentType.IT,
                    itDirector,
                    Collections.singletonList("English"));
    }

    @Test
    public void TEST_throwEmployeeAgeExceptionInConstructor(){
        expectedException.expect(AgeException.class);
        expectedException.expectMessage("Age cannot be negative or zero.");
            Employee employee = new Employee(
                    "TestName",
                    "TestSurname",
                    -23,
                    2000,
                    "mail@mail.com",
                    DepartmentType.IT,
                    itDirector,
                    Collections.singletonList("English"));
    }

    @Test
    public void TEST_throwEmployeeSalaryExceptionInConstructor(){
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Salary cannot be negative.");
        Employee employee = new Employee(
                "TestName",
                "TestSurname",
                23,
                -2000,
                "mail@mail.com",
                DepartmentType.IT,
                itDirector,
                Collections.singletonList("English"));
    }

    @Test
    public void TEST_throwSalaryNotInRangeExceptionUnderInConstructor(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 2000.0 is under global min salary: " + Job.globalMinSalary);
        Employee employee = new Employee(
                "TestName",
                "TestSurname",
                23,
                2000,
                "mail@mail.com",
                DepartmentType.IT,
                itDirector,
                Collections.singletonList("English"));
    }

    @Test
    public void TEST_throwSalaryNotInRangeExceptionOverInConstructor(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 21000.0 exceeds global max salary: " + Job.globalMaxSalary);
        Employee employee = new Employee(
                "TestName",
                "TestSurname",
                23,
                21000,
                "mail@mail.com",
                DepartmentType.IT,
                itDirector,
                Collections.singletonList("English"));
    }

    @Test
    public void TEST_throwDifferentDepartmentTypeExceptionInConstructor(){
        expectedException.expect(DifferentDepartmentTypeException.class);
        expectedException.expectMessage("Employees department IT is different then job departement Executive");
        Employee employee = new Employee(
                "TestName",
                "TestSurname",
                23,
                20000,
                "mail@mail.com",
                DepartmentType.IT,
                executive,
                Collections.singletonList("English"));
    }

/**************************************
     SetSalary tests (with exceptions)
**************************************/

    @Test
    public void TEST_setSalary(){
        assertEquals(5000, employeeTester.getSalary(),0);
        employeeTester.setSalary(6000);
        assertEquals(6000, employeeTester.getSalary(),0);
    }

    @Test
    public void TEST_throwsNegativeSalaryExceptionInSetSalary(){
        assertEquals(5000, employeeTester.getSalary(),0);
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Salary cannot be negative.");
        employeeTester.setSalary(-1000);
    }

    @Test
    public void TEST_throwUnderSalaryNotInRageExceptionInSetter(){
        assertEquals(5000, employeeTester.getSalary(),0);
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 2000.0 is under global min salary: " + Job.globalMinSalary);
        employeeTester.setSalary(2000);
    }

    @Test
    public void TEST_throwOverSalaryNotInRangeExceptionInSetter(){
        assertEquals(5000, employeeTester.getSalary(),0);
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 22000.0 exceeds global max salary: " + Job.globalMaxSalary);
        employeeTester.setSalary(22000);
    }

/**************************************
     Increase salary tests
**************************************/

    @Test
    public void TEST_increaseSalary(){
        assertEquals(5000, employeeTester.getSalary(), 0);
        employeeTester.increaseSalary(1000);
        assertEquals(6000, employeeTester.getSalary(), 0);
    }

    @Test
    public void TEST_throwIncreaseChangeSalaryException(){
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Raise amount must be greater then 0.");
        employeeTester.increaseSalary(-1000);
    }

    @Test
    public void TEST_throwExceedsChangeSalaryException(){
        Employee employee = new Employee(
                "TestName",
                "TestSurname",
                23,
                15000,
                "mail@mail.com",
                DepartmentType.IT,
                itDirector,
                Collections.singletonList("English"));

        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Raising salary: 15000.0 + 6000.0 = 21000.0 exceeds global company max salary 20000.0");
        employee.increaseSalary(6000);
    }

    @Test
    public void TEST_decreaseSalary(){
        assertEquals(5000, employeeTester.getSalary(), 0);
        employeeTester.decreaseSalary(1000);
        assertEquals(4000, employeeTester.getSalary(), 0);
    }

/**************************************
     Decrease salary tests
**************************************/

    @Test
    public void TEST_throwUnderSalaryNotInRangeExceptionInDecreaseSalaryMethod(){
        assertEquals(5000, employeeTester.getSalary(), 0);
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Decreasing salary: 5000.0 - 3000.0 = 2000.0 is under global company min salary 3000.0");
        employeeTester.decreaseSalary(3000);
    }

    @Test
    public void TEST_throwDecreaseChangeSalaryException(){
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Decrease amount must be greater then 0.");
        employeeTester.decreaseSalary(-1000);
    }

/**************************************
     Equals and HashCode tests
**************************************/

    @Test
    public void TEST_toString(){
        Employee employee = new Employee(
                "Name",
                "Surname",
                33,
                5000,
                "mail@mail.com",
                DepartmentType.IT,
                itDirector,
                Arrays.asList("English", "Spanish")
        );
        String expected = "Employee{id=0, name='Name', surname='Surname', age=33, salary=5000.0, email='mail@mail.com', " +
                "department=IT, job=Director, languages=[English, Spanish]}";
        String actual = employee.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void TEST_hashCode(){
        Employee employee = new Employee(
                "Name",
                "Surname",
                33,
                5000,
                "mail@mail.com",
                DepartmentType.IT,
                itDirector,
                Arrays.asList("English", "Spanish")
        );

        Employee employee1 = new Employee(
                "Name",
                "Surname",
                33,
                5000,
                "mail@mail.com",
                DepartmentType.IT,
                itDirector,
                Arrays.asList("English", "Spanish")
        );

        Employee employee2 = new Employee(
                "Name2",
                "Surname2",
                34,
                6000,
                "mail2@mail.com",
                DepartmentType.IT,
                itDirector,
                Collections.singletonList("English")
        );

        assertEquals(employee, employee1);
        assertNotEquals(employee, employee2);

        assertEquals(employee.hashCode(), employee1.hashCode());
        assertNotEquals(employee.hashCode(), employee2.hashCode());
    }

/**************************************
 Set  tests
 **************************************/

    @Test
    public void TEST_setJob(){
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                25,
                5000,
                "email@email.com",
                DepartmentType.Executive,
                executive,
                Arrays.asList("English", "Spanish")
        );

        Job newExecutiveJob = new Job(101, "Executive director", 10000,20000, DepartmentType.Executive);

        employee.setJob(newExecutiveJob);
    }

    @Test
    public void TEST_throwDifferentDepartmentTypeExceptionSetJob(){
        Employee employee = new Employee(
                "FirstName",
                "LastName",
                25,
                5000,
                "email@email.com",
                DepartmentType.Executive,
                executive,
                Arrays.asList("English", "Spanish")
        );

        Job financeJob = new Job(101, "Finance job", 10000,20000, DepartmentType.Finance);

        expectedException.expect(DifferentDepartmentTypeException.class);
        expectedException.expectMessage("Employees department Executive is different then job department Finance");

        employee.setJob(financeJob);
    }

}
