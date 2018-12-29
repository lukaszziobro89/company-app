package com.mycompany.app;

import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.exceptions.AgeException;
import com.mycompany.exceptions.ChangeSalaryException;
import com.mycompany.exceptions.NegativeSalaryException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class Employee_Test {

    private Employee employeeTester = new Employee(
            "FirstName",
            "LastName",
            25,
            3000,
            "email@email.com",
            DepartmentType.Executive,
            Arrays.asList("English", "Spanish")
    );

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void TEST_createEmployee(){
            Employee employee = new Employee(
                    "TestName",
                    "TestSurname",
                    23,
                    2000,
                    "mail@mail.com",
                    DepartmentType.IT,
                    Collections.singletonList("English"));
    }

    @Test
    public void TEST_toString(){
        Employee employee = new Employee(
                "Name",
                "Surname",
                33,
                5000,
                "mail@mail.com",
                DepartmentType.Marketing,
                Arrays.asList("English", "Spanish")
        );
        String expected = "Employee{id=0, name='Name', surname='Surname', age=33, salary=5000.0, email='mail@mail.com', department=Marketing, languages=[English, Spanish]}";
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
                DepartmentType.Marketing,
                Arrays.asList("English", "Spanish")
        );

        Employee employee1 = new Employee(
                "Name",
                "Surname",
                33,
                5000,
                "mail@mail.com",
                DepartmentType.Marketing,
                Arrays.asList("English", "Spanish")
        );

        Employee employee2 = new Employee(
                "Name2",
                "Surname2",
                34,
                6000,
                "mail2@mail.com",
                DepartmentType.Marketing,
                Collections.singletonList("English")
        );

        assertEquals(employee, employee1);
        assertNotEquals(employee, employee2);

        assertEquals(employee.hashCode(), employee1.hashCode());
        assertNotEquals(employee.hashCode(), employee2.hashCode());
    }

    @Test
    public void TEST_throwEmployeeAgeException(){
        expectedException.expect(AgeException.class);
        expectedException.expectMessage("Age cannot be negative or zero.");
            Employee employee = new Employee(
                    "TestName",
                    "TestSurname",
                    -23,
                    2000,
                    "mail@mail.com",
                    DepartmentType.IT,
                    Collections.singletonList("English"));
    }

    @Test
    public void TEST_throwEmployeeSalaryException(){
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Salary cannot be negative.");
        Employee employee = new Employee(
                "TestName",
                "TestSurname",
                23,
                -2000,
                "mail@mail.com",
                DepartmentType.IT,
                Collections.singletonList("English"));
    }

    @Test
    public void TEST_increaseSalary(){
        assertEquals(3000, employeeTester.getSalary(), 0);
        employeeTester.increaseSalary(1000);
        assertEquals(4000, employeeTester.getSalary(), 0);
    }

    @Test
    public void TEST_throwIncreaseChangeSalaryException(){
        expectedException.expect(ChangeSalaryException.class);
        expectedException.expectMessage("Raise amount must be greater then 0.");
        employeeTester.increaseSalary(-1000);
    }

    @Test
    public void TEST_decreaseSalary(){
        assertEquals(3000, employeeTester.getSalary(), 0);
        employeeTester.decreaseSalary(1000);
        assertEquals(2000, employeeTester.getSalary(), 0);
    }

    @Test
    public void TEST_throwDecreaseChangeSalaryException(){
        expectedException.expect(ChangeSalaryException.class);
        expectedException.expectMessage("Decrease amount must be greater then 0.");
        employeeTester.decreaseSalary(-1000);
    }
}
