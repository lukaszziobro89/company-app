package com.mycompany.app;

import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Job;
import com.mycompany.exceptions.NegativeSalaryException;
import com.mycompany.exceptions.SalaryNotInRangeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class Job_Test {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void TEST_createJobConstructor(){
        Job job = new Job(10, "Java Developer", 5000, 20000, DepartmentType.IT);
        Job job1 = new Job(20, "Java Developer", 5000, 20000, DepartmentType.IT);
        Job job2 = new Job(30, "Java Developer", 6000, 20000, DepartmentType.IT);
        assertEquals(10, job.getJobId());
        assertEquals(20, job1.getJobId());
        assertEquals(30, job2.getJobId());
    }

    @Test
    public void TEST_minSalaryThrowNegativeSalaryException(){
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Salary cannot be negative.");
        Job job = new Job(10, "Java Developer", -5000, 20000, DepartmentType.IT);
    }

    @Test
    public void TEST_throwSalaryNotInRangeExceptionMinSalaryGreaterThenGlobalMaxSalary(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 21000.0 exceeds global max salary: 20000.0");
        Job job = new Job(10, "Java Developer", 21000, 20000, DepartmentType.IT);
    }

    @Test
    public void TEST_throwSalaryNotInRangeExceptionMinSalaryLessThenGlobalMinSalary(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 2000.0 is under global min salary: 3000.0");
        Job job = new Job(10, "Java Developer", 2000, 20000, DepartmentType.IT);
    }

    @Test
    public void TEST_throwSalaryNotInRangeExceptionMinSalaryGreaterThenMaxSalary(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Min salary 6000.0 is greater then max salary 5000.0");
        Job job = new Job(10, "Java Developer", 6000, 5000, DepartmentType.IT);
    }

    @Test
    public void TEST_throwNegativeSalaryExceptionMaxSalary(){
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Salary cannot be negative.");
        Job job = new Job(10, "Java Developer", 6000, -6000, DepartmentType.IT);
    }

    @Test
    public void TEST_throwMaxSalaryExceedsGlobalMaxSalary(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 36000.0 exceeds global max salary: 20000.0");
        Job job = new Job(10, "Java Developer", 6000, 36000, DepartmentType.IT);
    }

    @Test
    public void TEST_setMinSalary(){
        Job job = new Job(10, "Java Developer", 5000, 20000, DepartmentType.IT);
        assertEquals(5000.0, job.getMinSalary());
        job.setMinSalary(4000);
        assertEquals(4000.0, job.getMinSalary());
    }

    @Test
    public void TEST_throwExceptionNegativeSalaryExceptionSetMinSalary(){
        Job job = new Job(10, "Java Developer", 5000, 20000, DepartmentType.IT);
        expectedException.expect(NegativeSalaryException.class);
        expectedException.expectMessage("Salary cannot be negative.");
        job.setMinSalary(-2000);
    }

    @Test
    public void TEST_throwExceptionMinSalaryGreaterThenGlobalMaxSalarySetMinSalary(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 25000.0 exceeds global max salary: 20000.0");
        Job job = new Job(10, "Java Developer", 25000, 20000, DepartmentType.IT);
    }

    @Test
    public void TEST_throwExceptionMinSalaryUnderGlobalMinSalarySetMinSalary(){
        expectedException.expect(SalaryNotInRangeException.class);
        expectedException.expectMessage("Salary 2000.0 is under global min salary: 3000.0");
        Job job = new Job(10, "Java Developer", 2000, 20000, DepartmentType.IT);
    }

//    @Test
//    public void TEST_throwExceptionMinSalaryGreaterThenMaxSalarySetMinSalary(){
//
//    }

    @Test
    public void TEST_equalsMethod(){
        Job job = new Job(10, "Java Developer", 5000, 20000, DepartmentType.IT);
        Job job1 = new Job(20, "Java Developer", 5000, 20000, DepartmentType.IT);
        Job job2 = new Job(30, "Java Developer", 6000, 20000, DepartmentType.IT);
        assertEquals(job, job1);
        assertNotEquals(job1, job2);
    }

    @Test
    public void TEST_hashCodeMethod(){
        Job job = new Job(10, "Java Developer", 5000, 20000, DepartmentType.IT);
        Job job1 = new Job(20, "Java Developer", 5000, 20000, DepartmentType.IT);
        Job job2 = new Job(30, "Java Developer", 6000, 20000, DepartmentType.IT);

        assertEquals(job.hashCode(), job1.hashCode());
        assertNotEquals(job1.hashCode(), job2.hashCode());
    }


}
