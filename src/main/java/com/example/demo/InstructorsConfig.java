package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class InstructorsConfig {

    Instructors tcUsaInstructors = new Instructors (
            new Instructor(1, "Hector Diaz"),
            new Instructor(2, "Susan Smith"));
    Instructors tcUkInstructors = new Instructors(
            new Instructor(3, "Ann Hickman"),
            new Instructor(4, "John Dole"));


    @Bean
    Instructors tcUsaInstructors(){
        return tcUsaInstructors;
    }

    @Bean(name = "UK")
    Instructors tcUkInstructors(){
        return tcUkInstructors;
    }

    @Bean
    @Primary
    Instructors instructors(){
        Instructors instructors =  new Instructors();
        instructors.addAll(tcUsaInstructors);
        instructors.addAll(tcUkInstructors);

        return instructors;
    }
}
