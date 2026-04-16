package com.juanfedevmaster.jsonfileexample.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.juanfedevmaster.jsonfileexample.Model.Person;
import com.juanfedevmaster.jsonfileexample.interfaces.IPersonRepository;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PersonRepository implements IPersonRepository {

    @Override
    public boolean saveListPeople(List<Person> peopleList) {
        try {

            var peopleToSave = new ArrayList<String>();

            if (!Files.exists(Paths.get("People.txt"))) {
                Files.createFile(Paths.get("People.txt"));
            }

            for (Person p : peopleList) {
                String value = p.getId() + "," + p.getName() + "," + p.getLastName() + "," + p.getAge(); // Firts Option to save:  + "\n";
                peopleToSave.add(value);
                // Files.write(Paths.get("People.txt"), value.getBytes(),StandardOpenOption.APPEND); // First Option to save
            }

            Files.write(Paths.get("People.txt"), peopleToSave, StandardOpenOption.APPEND);

        } catch (Exception exe) {
            return false;
        }
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
    public List<Person> getPeople() throws Exception {
        var people = new ArrayList<Person>();
        var path = Paths.get("People.txt");

        try {
            if (!Files.exists(Paths.get("People.txt"))) {
                return people;
            }

            var lines = Files.readAllLines(path);

            for (String data : lines) {

                if (data == null || data.trim().isEmpty()) {
                    continue;
                }

                String[] fields = data.split(",");
                var person = new Person(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]));

                people.add(person);
            }

            return people;

        } catch (Exception exe) {
            throw new Exception("Error reading of the file: ");
        }
    }

    @Override
    public boolean saveListPeopleJson(List<Person> peopleList) {
        var path = Paths.get("PeopleJson.txt");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            String jsonValue = gson.toJson(peopleList);
            Files.writeString(path, jsonValue, StandardCharsets.UTF_8);
            return true;
        } catch (Exception exe) {
            return false;
        }
    }

    @Override
    public List<Person> getPeopleJson() throws Exception {
        var path = Paths.get("PeopleJson.txt");
        Gson gson = new Gson();
        var people = new ArrayList<Person>();

        try {
            if (!Files.exists(Paths.get("People.txt"))) {
                return people;
            }

            String jsonValue = Files.readString(path, StandardCharsets.UTF_8);

            Type listType = new TypeToken<List<Person>>() { }.getType();
            people = gson.fromJson(jsonValue, listType);
            
            return people;
            
        } catch (Exception exe) {
            throw new Exception("Error reading of the file: PeopleJson.txt");
        }
    }

}
