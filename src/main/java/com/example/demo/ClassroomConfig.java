package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ClassroomConfig {

    @Bean
    @DependsOn({"instructors", "currentStudents"})
    Classroom currentCohort(Instructors instructors, Students currentStudents){
        return new Classroom(instructors, currentStudents);
    }

    @Bean
    @DependsOn({"instructors", "previousStudents"})
    Classroom previousCohort(Instructors instructors, Students previousStudents){
        return new Classroom(instructors, previousStudents);
    }

}
