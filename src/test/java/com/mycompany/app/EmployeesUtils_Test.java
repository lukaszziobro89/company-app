package com.mycompany.app;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.utils.EmployeesUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeesUtils_Test {
    private EmployeesUtils employeesUtils = new EmployeesUtils();
    private static Department MarketingDepartment = new Department(DepartmentType.Marketing);

    @BeforeClass
    public static void createDepartment(){
        Department marketingDepartment = new Department(DepartmentType.Finance);
        Employee employee = new Employee("FirstName", "LastName", 33, 3000,
                "mail@mail.com", DepartmentType.Executive, Arrays.asList("English","Spanish"));
        Employee employee1 = new Employee("FirstName1", "LastName1", 34, 4000,
                "mail@mail.com", DepartmentType.Executive, Arrays.asList("English", "German"));
        Employee employee2 = new Employee("FirstName2", "LastName2", 35, 5000,
                "mail@mail.com", DepartmentType.Executive, Arrays.asList("English", "Polish"));
        Employee employee3 = new Employee("FirstName3", "LastName3", 36, 6000,
                "mail@mail.com", DepartmentType.Executive, Collections.singletonList("English"));
        Employee employee4 = new Employee("FirstName4", "LastName4", 37, 7000,
                "mail@mail.com", DepartmentType.Executive, Collections.singletonList("English"));
        Employee employee5 = new Employee("FirstName5", "LastName5", 38, 8000,
                "mail@mail.com", DepartmentType.Executive, Arrays.asList("English", "Spanish"));
        marketingDepartment.addEmployeeToEmployeesList(employee);
        marketingDepartment.addEmployeeToEmployeesList(employee1);
        marketingDepartment.addEmployeeToEmployeesList(employee2);
        marketingDepartment.addEmployeeToEmployeesList(employee3);
        marketingDepartment.addEmployeeToEmployeesList(employee4);
        marketingDepartment.addEmployeeToEmployeesList(employee5);
        MarketingDepartment = marketingDepartment;
    }

    @Test
    public void TEST_getAllLanguagesEmployeesSpeakFromDepartment(){
        List<String> marketingLanguages = employeesUtils.getAllLanguagesEmployeesSpeakFromDepartment(MarketingDepartment);
        List<String> assertLanguages = Arrays.asList("English", "Spanish", "German", "Polish");

        assertEquals(assertLanguages, marketingLanguages);
    }

    @Test
    public void TEST_getEmployeesBetweenAge(){
        List<Employee> employeesHigher34lower37 = employeesUtils.getEmployeesBetweenAge(MarketingDepartment, 34,37);
        List<Employee> assertEmployees = Arrays.asList(
                MarketingDepartment.getEmployeeList().get(2),
                MarketingDepartment.getEmployeeList().get(3)
        );

        assertEquals(assertEmployees, employeesHigher34lower37);
    }

    @Test
    public void TEST_countEmployeesWithLanguage(){
        long countEnglish = 6;
        long countSpanish = 2;

        assertEquals(countEnglish, employeesUtils.countEmployeesWithLanguage(MarketingDepartment, "English"));
        assertEquals(countSpanish, employeesUtils.countEmployeesWithLanguage(MarketingDepartment, "Spanish"));
    }

    @Test
    public void TEST_getEmployeesWithLanguage(){
        List<Employee> assertEmployees = Arrays.asList(
                MarketingDepartment.getEmployeeList().get(0),
                MarketingDepartment.getEmployeeList().get(5)
        );

        assertEquals(assertEmployees, employeesUtils.getEmployeesWithLanguage(MarketingDepartment, "Spanish"));
    }

    @Test
    public void TEST_raiseSalaryForEmployeesBeginLetter(){
        assertEquals(3000, MarketingDepartment.getEmployeeList().get(0).getSalary(),0);
        assertEquals(4000, MarketingDepartment.getEmployeeList().get(1).getSalary(),0);
        assertEquals(5000, MarketingDepartment.getEmployeeList().get(2).getSalary(),0);
        assertEquals(6000, MarketingDepartment.getEmployeeList().get(3).getSalary(),0);
        assertEquals(7000, MarketingDepartment.getEmployeeList().get(4).getSalary(),0);
        assertEquals(8000, MarketingDepartment.getEmployeeList().get(5).getSalary(),0);

        employeesUtils.raiseSalaryForEmployeesBeginLetter(MarketingDepartment.getEmployeeList(),"F", 100);

        assertEquals(3100, MarketingDepartment.getEmployeeList().get(0).getSalary(),0);
        assertEquals(4100, MarketingDepartment.getEmployeeList().get(1).getSalary(),0);
        assertEquals(5100, MarketingDepartment.getEmployeeList().get(2).getSalary(),0);
        assertEquals(6100, MarketingDepartment.getEmployeeList().get(3).getSalary(),0);
        assertEquals(7100, MarketingDepartment.getEmployeeList().get(4).getSalary(),0);
        assertEquals(8100, MarketingDepartment.getEmployeeList().get(5).getSalary(),0);
    }
}
