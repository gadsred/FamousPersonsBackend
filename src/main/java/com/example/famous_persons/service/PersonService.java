package com.example.famous_persons.service;


import java.util.Optional;

import com.example.famous_persons.dao.UserRepository;
import com.example.famous_persons.dao.PersonRepositoryJpa;
import com.example.famous_persons.model.Person;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    // private final PersonDao personDao;

    // @Autowired
    // public PersonService(@Qualifier("postgres") PersonDao personDao) {
    // this.personDao = personDao;
    // }
    @Autowired
    private UserRepository repository;
    @Autowired
    private PersonRepositoryJpa personRepository;

    public Person addPerson(Person person) {
        return repository.save(person);
    }

    public Iterable<Person> getAllPeople() {
        return repository.findAll();
    }

    public Iterable<Person> findPersons(String name) {
        return personRepository.find(name);
    }

 
	public Optional<Person> getPersonById(Integer id) {
        return repository.findById(id);
    }

    public int deletePersonById(Integer id) {
        repository.deleteById(id);
        return 1;
        
    }

    public int updatePerson(Person newPerson){
        repository.save(newPerson);
        return 1;
    }
}