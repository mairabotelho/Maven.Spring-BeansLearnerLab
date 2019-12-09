package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    Students currentStudents = new Students(
            new Student(1,"Andy Bernard"),
            new Student(2,"Oscar Martinez"));
    Students previousStudents = new Students(
            new Student(1,"Michael Scott"),
            new Student(2,"Angela Martin"),
            new Student(3,"Phyllis Vance"));

    @Bean(name = "currentStudents")
    public Students currentStudents(){
        return currentStudents;
    }

    @Bean(name = "previousStudents")
    public Students previousStudents(){
        return previousStudents;
    }
}
