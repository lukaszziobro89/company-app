package com.mycompany.app;

import com.mycompany.entity.DepartmentType;
import com.mycompany.entity.Job;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

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


}
