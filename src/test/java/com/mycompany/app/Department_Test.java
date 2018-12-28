package com.mycompany.app;

import com.mycompany.entity.Department;
import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Employee;
import com.mycompany.entity.Job;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Department_Test {

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

    // TODO: Throw JobAlreadyInListException test

    // TODO: Throw DifferentDepartmentTypeException test


}
