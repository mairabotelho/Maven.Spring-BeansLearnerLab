package com.example.demo;

import java.util.Collection;

public interface Teacher {

    void teach(Learner learner, double numberOfHours);

    void lecture(Collection<? extends Learner> learners, double numberOfHours);

}
