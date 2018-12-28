package com.mycompany.app;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;

import java.util.Arrays;

public class App {
    public static void main( String[] args ) {
        Employee employee = new Employee("Lukasz", "Ziobro",29,2000,"lu@wp.pl", DepartmentType.IT, Arrays.asList("Polish","English"));

    }
}
