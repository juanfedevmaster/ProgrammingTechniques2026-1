package com.juanfedevmaster.jsonfileexample.interfaces;

import java.util.List;

import com.juanfedevmaster.jsonfileexample.Model.Person;

public interface IPersonService {
    boolean saveListPeople(List<Person> peopleList) throws Exception;
    boolean savePerson(Person p);
    boolean find(Person p);
    
    boolean saveListPeopleJson(List<Person> peopleList) throws Exception;
}
