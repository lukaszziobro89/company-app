package com.mycompany.app;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;
import com.mycompany.utils.DepartmentsUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class DepartmentsUtils_Test {

    private DepartmentsUtils departmentsUtils = new DepartmentsUtils();
    private static Department FinanceDepartment = new Department(DepartmentType.Finance);
    private static Job executiveManager = new Job(40,"Executive Manager", 18000, 20000,DepartmentType.Executive);

    @BeforeClass
    public static void createDepartment(){
        Department FinanceDepartement = new Department(DepartmentType.Finance);
        Employee employee = new Employee("FirstName", "LastName", 33, 3000,
                "mail@mail.com", DepartmentType.Executive, executiveManager, Collections.singletonList("English"));
        Employee employee1 = new Employee("FirstName1", "LastName1", 34, 4000,
                "mail@mail.com", DepartmentType.Executive, executiveManager, Collections.singletonList("English"));
        Employee employee2 = new Employee("FirstName2", "LastName2", 35, 5000,
                "mail@mail.com", DepartmentType.Executive, executiveManager, Collections.singletonList("English"));
        Employee employee3 = new Employee("FirstName3", "LastName3", 36, 6000,
                "mail@mail.com", DepartmentType.Executive, executiveManager, Collections.singletonList("English"));
        Employee employee4 = new Employee("FirstName4", "LastName4", 37, 7000,
                "mail@mail.com", DepartmentType.Executive, executiveManager, Collections.singletonList("English"));
        Employee employee5 = new Employee("FirstName5", "LastName5", 38, 8000,
                "mail@mail.com", DepartmentType.Executive, executiveManager, Collections.singletonList("English"));
        FinanceDepartement.addEmployeeToEmployeesList(employee);
        FinanceDepartement.addEmployeeToEmployeesList(employee1);
        FinanceDepartement.addEmployeeToEmployeesList(employee2);
        FinanceDepartement.addEmployeeToEmployeesList(employee3);
        FinanceDepartement.addEmployeeToEmployeesList(employee4);
        FinanceDepartement.addEmployeeToEmployeesList(employee5);
        FinanceDepartment = FinanceDepartement;
    }


    @Test
    public void TEST_countAverageSalaryForDepartment(){
        double assertValue = 5500;
        double averageFinanceSalary = departmentsUtils.countAverageSalaryForDepartment(FinanceDepartment);

        assertEquals(assertValue, averageFinanceSalary,0);
    }

    @Test
    public void TEST_sumSalariesForDepartment(){
        double sumFinance = departmentsUtils.sumSalariesForDepartment(FinanceDepartment);
        assertEquals(33000.0, sumFinance,0);
    }
}
