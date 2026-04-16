package com.juanfedevmaster.jsonfileexample.services;

import java.util.List;

import com.juanfedevmaster.jsonfileexample.Model.Person;
import com.juanfedevmaster.jsonfileexample.interfaces.IPersonRepository;
import com.juanfedevmaster.jsonfileexample.interfaces.IPersonService;
import com.juanfedevmaster.jsonfileexample.repositories.PersonRepository;

public class PersonService implements IPersonService {

    private final IPersonRepository personRepo;
    public PersonService(){
        personRepo = new PersonRepository();
    }

    @Override
    public boolean saveListPeople(List<Person> peopleList) throws Exception {
        
        if(peopleList == null){
            throw new Exception("The people list is empty");
        }
        
        var flag = personRepo.saveListPeople(peopleList);

        return true;
        
    }

    @Override
    public boolean savePerson(Person p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savePerson'");
    }

    @Override
    public boolean find(Person p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public boolean saveListPeopleJson(List<Person> peopleList) throws Exception {
        if(peopleList == null){
            throw new Exception("The people list is empty");
        }
        
        var flag = personRepo.saveListPeopleJson(peopleList);

        return true;
    }

}
