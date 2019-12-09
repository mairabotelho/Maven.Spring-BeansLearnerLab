package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

abstract class People <PersonType extends Person> implements Iterable<PersonType> {

    private ArrayList<PersonType> personList;

    public People(PersonType... personList) {
        if(personList != null)
            this.personList = new ArrayList<>(Arrays.asList(personList));
        else
            this.personList = new ArrayList<>();
    }

    public void add(PersonType person){
        personList.add(person);
    }

    public void remove(PersonType person){
        personList.remove(person);
    }

    public int size(){
        return personList.size();
    }

    public void clear(){
        personList.clear();
    }

    public void addAll(Iterable<PersonType> list){
        list.forEach(person -> personList.add(person));
    }

    public PersonType findById(long id){
        return personList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public ArrayList<PersonType> findAll(){
        return personList;
    }

    @Override
    public Iterator<PersonType> iterator() {
        return personList.iterator();
    }
}
