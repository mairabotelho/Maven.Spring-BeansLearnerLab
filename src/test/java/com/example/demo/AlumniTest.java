package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AlumniTest {

    @Autowired
    @Qualifier("previousStudents")
    Students previousStudents;

    @Autowired
    @Qualifier("instructors")
    Instructors instructors;

    @Test
    void studentTime() {

        Assert.assertEquals(3, previousStudents.size());
        Assert.assertEquals(1200.0, previousStudents.findById(2).getTotalStudyTime(), 0.0);
    }

    @Test
    void instructorTime(){

        Assert.assertEquals(4, instructors.size());
        Assert.assertEquals(900, instructors.findById(1).numberOfHoursTaught, 0.0);
        Assert.assertEquals(900, instructors.findById(3).numberOfHoursTaught, 0.0);
    }
}