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
class InstructorsConfigTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    @Qualifier("tcUsaInstructors")
    Instructors tcUsaInstructors;

    @Test
    void tcUsaInstructors() {

        Assert.assertEquals(2, tcUsaInstructors.size());
    }

    @Test
    void tcUkInstructors() {
        Instructors instructors = applicationContext.getBean("UK", Instructors.class);
        Instructor instructor = instructors.findById(4);

        Assert.assertEquals(instructor.getName(), "John Dole");
    }

    @Test
    void instructors() {
        Instructors instructors = applicationContext.getBean(Instructors.class);

        Assert.assertEquals(4, instructors.size());
    }
}