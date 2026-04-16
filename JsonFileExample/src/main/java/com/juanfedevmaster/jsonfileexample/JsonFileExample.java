/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.juanfedevmaster.jsonfileexample;

import com.google.gson.Gson;
import com.juanfedevmaster.jsonfileexample.Model.Person;
import com.juanfedevmaster.jsonfileexample.interfaces.IPersonRepository;
import com.juanfedevmaster.jsonfileexample.interfaces.IPersonService;
import com.juanfedevmaster.jsonfileexample.repositories.PersonRepository;
import com.juanfedevmaster.jsonfileexample.services.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author juanfe
 */
public class JsonFileExample {

    public static void main(String[] args) {

        /*var person = new Person("Juan Felipe", "Quintana", 40);
        JSONObject obj = new JSONObject();
        
        
        obj.put("name", person.getName());
        obj.put("lastName", person.getLastName());
        obj.put("age", person.getAge());
        
        System.out.println(obj);
        
        
        var people = new ArrayList<Person>();
        
        people.add(new Person(1,"Juan Felipe","Quintana",40));
        people.add(new Person(2,"Laura","Quintana",36));
        people.add(new Person(3,"Camilo","Gómez",46));
        
        Gson gson = new Gson();
        var jsonFormat = gson.toJson(people);
        
        System.out.println(jsonFormat);*/
        List<Person> people = new ArrayList<Person>();

        people.add(new Person(1, "Juan Felipe", "Quintana", 40));
        people.add(new Person(2, "Laura", "Quintana", 36));
        people.add(new Person(4, "Camilo", "Gómez", 46));
        people.add(new Person(5, "Sara", "Guitierrez", 32));
        
        IPersonService personService = new PersonService();
        IPersonRepository personRespo = new PersonRepository();
        try {
            boolean save = personService.saveListPeople(people);
            boolean saveJson = personService.saveListPeopleJson(people);
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        people = new ArrayList<Person>();

        try {
            people = personRespo.getPeopleJson();

            for (var person : people) {
                System.out.println("Name: " + person.getId() + " Last Name: " + person.getLastName() + " Age: " + person.getAge());
            }

        } catch (Exception ex) {
            Logger.getLogger(JsonFileExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
