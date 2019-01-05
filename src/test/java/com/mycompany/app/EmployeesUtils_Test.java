package com.mycompany.app;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.utils.DepartmentsUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class EmployeesUtils_Test {
    private DepartmentsUtils departmentsUtils = new DepartmentsUtils();
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
                "mail@mail.com", DepartmentType.Executive, Collections.singletonList("English"));
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

    }
}
