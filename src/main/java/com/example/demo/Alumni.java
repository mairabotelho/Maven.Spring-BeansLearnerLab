package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {
    @Autowired
    @Qualifier("previousStudents")
    Students previousStudents;

    @Autowired
    @Qualifier("instructors")
    Instructors instructors;

    @PostConstruct
    void executeBootcamp(){
        int numberOfInstructors = instructors.size();
        int numberOfStudents = previousStudents.size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;

        for(Instructor instructor : instructors)
            instructor.lecture(previousStudents.findAll(), numberOfHoursPerInstructor);
    }

    public Students getPreviousStudents() {
        return previousStudents;
    }

    public Instructors getInstructors() {
        return instructors;
    }
}
