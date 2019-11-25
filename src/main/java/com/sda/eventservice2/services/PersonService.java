package com.sda.eventservice2.services;

import com.sda.eventservice2.dao.PersonRepository;
import com.sda.eventservice2.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Could not find Person with id: " + id));
    }

    public List<Person> getAllEvents() {
        return personRepository.findAll();
    }

    public Person createNewPerson(Person person) {
        return personRepository.save(person);
    }
}
