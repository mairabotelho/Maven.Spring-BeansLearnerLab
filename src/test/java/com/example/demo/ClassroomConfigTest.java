package com.example.demo;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ClassroomConfigTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    @Qualifier("currentCohort")
    Classroom currentCohort;

    @Autowired
    @Qualifier("previousCohort")
    Classroom previousCohort;

    @Test
    void currentCohortTest() {

        Assert.assertEquals(4, currentCohort.getInstructors().size());
        Assert.assertEquals(2, currentCohort.getStudents().size());
    }

    @Test
    void previousCohort() {

        Assert.assertEquals(4, previousCohort.getInstructors().size());
        Assert.assertEquals(3,previousCohort.getStudents().size());
    }
}