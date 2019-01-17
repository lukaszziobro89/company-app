package com.mycompany.app;

import com.mycompany.departments.FinanceDepartment;
import com.mycompany.departments.ITDepartment;
import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;
import com.mycompany.utils.EmployeePredicates;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.mycompany.utils.EmployeePredicates.*;
import static org.junit.Assert.assertEquals;

public class EmployeePredicates_Test {

    private static Department FinanceDepartment = new ITDepartment(DepartmentType.Finance);

    @BeforeClass
    public static void createDepartment() {
        Department FinanceDepartement = new FinanceDepartment(DepartmentType.Finance);

        Job financeExecutiveManager = new Job(40, "Executive Manager", 18000, 20000, DepartmentType.Finance);

        Employee employee = new Employee("FirstName", "LastName", 33, 3000,
                "mail@mail.com", DepartmentType.Finance, financeExecutiveManager, Collections.singletonList("English"));
        Employee employee1 = new Employee("FirstName1", "LastName1", 34, 4000,
                "mail@mail.com", DepartmentType.Finance, financeExecutiveManager, Collections.singletonList("English"));
        Employee employee2 = new Employee("FirstName2", "LastName2", 35, 5000,
                "mail@mail.com", DepartmentType.Finance, financeExecutiveManager, Collections.singletonList("English"));
        Employee employee3 = new Employee("FirstName3", "LastName3", 36, 6000,
                "mail@mail.com", DepartmentType.Finance, financeExecutiveManager, Collections.singletonList("English"));
        Employee employee4 = new Employee("FirstName4", "LastName4", 37, 7000,
                "mail@mail.com", DepartmentType.Finance, financeExecutiveManager, Collections.singletonList("English"));
        Employee employee5 = new Employee("FirstName5", "LastName5", 38, 8000,
                "mail@mail.com", DepartmentType.Finance, financeExecutiveManager, Collections.singletonList("English"));
        FinanceDepartement.addEmployeeToEmployeesList(employee);
        FinanceDepartement.addEmployeeToEmployeesList(employee1);
        FinanceDepartement.addEmployeeToEmployeesList(employee2);
        FinanceDepartement.addEmployeeToEmployeesList(employee3);
        FinanceDepartement.addEmployeeToEmployeesList(employee4);
        FinanceDepartement.addEmployeeToEmployeesList(employee5);
        FinanceDepartment = FinanceDepartement;
    }

    @Test
    public void TEST_isAgeMoreThen() {
        List<Employee> employeesAfter35 = Arrays.asList(
                FinanceDepartment.getEmployeeList().get(3),
                FinanceDepartment.getEmployeeList().get(4),
                FinanceDepartment.getEmployeeList().get(5)
        );

        List<Employee> assertEmployees = filterEmployees(FinanceDepartment.getEmployeeList(), isAgeMoreThen(35));

        assertEquals(employeesAfter35, assertEmployees);
    }

    @Test
    public void TEST_isBeforeAgeAndSalaryUnder() {
        List<Employee> before36andUnder5000 = Arrays.asList(
                FinanceDepartment.getEmployeeList().get(0),
                FinanceDepartment.getEmployeeList().get(1));

        List<Employee> assertEmployeesList = filterEmployees(
                FinanceDepartment.getEmployeeList(), isBeforeAgeAndSalaryUnder(36, 5000));

        assertEquals(before36andUnder5000, assertEmployeesList);
    }

    @Test
    public void TEST_isBeforeAgeAndSalaryOver() {
        List<Employee> before36andUnder3000 = Arrays.asList(
                FinanceDepartment.getEmployeeList().get(1),
                FinanceDepartment.getEmployeeList().get(2));

        List<Employee> assertEmployeesList = filterEmployees(
                FinanceDepartment.getEmployeeList(), isBeforeAgeAndSalaryOver(36, 3000));

        assertEquals(before36andUnder3000, assertEmployeesList);
    }

}
