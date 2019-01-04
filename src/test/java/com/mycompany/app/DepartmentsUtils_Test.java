package com.mycompany.app;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.utils.DepartmentsUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class DepartmentsUtils_Test {

    private DepartmentsUtils departmentsUtils = new DepartmentsUtils();

    @Test
    public void TEST_countAverageSalaryForDepartment(){
        Department FinanceDepartment = new Department(DepartmentType.Finance);
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

        FinanceDepartment.addEmployeeToEmployeesList(employee);
        FinanceDepartment.addEmployeeToEmployeesList(employee1);

        double assertValue = 4500;
        double averageFinanceSalary = departmentsUtils.countAverageSalaryForDepartment(FinanceDepartment);

        assertEquals(assertValue, averageFinanceSalary,0);
    }
}
