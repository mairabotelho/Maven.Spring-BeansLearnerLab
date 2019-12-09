package com.example.demo;


import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentConfigTest {

    @Autowired
    ApplicationContext applicationContext;


    @Test
    public void currentStudentsTest(){
        Students students = applicationContext.getBean("currentStudents", Students.class);
        Student student = students.findById(1);

        Assert.assertEquals(student.getName(), "Andy Bernard");
    }

    @Test
    public void previousStudents(){
        Students students = applicationContext.getBean("previousStudents", Students.class);

        Assert.assertEquals(3, students.size());
    }

}