package com.example.famous_persons.api;


import com.example.famous_persons.model.Person;
import com.example.famous_persons.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/person")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {

    private final PersonService personService;
   

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public Iterable<Person> getAllPeople() {
        return personService.getAllPeople();
    }


    @GetMapping(path = "/search/{name}")
    public Iterable<Person> findPersons(@PathVariable("name") String name){
        
		return personService.findPersons(name);
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
        
		return personService.getPersonById(id)
                            .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") Integer id){
         personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") Integer id,@RequestBody Person personToUpdate){
        if(id == personToUpdate.getId())
        {
            personService.updatePerson(personToUpdate);
        }
        
    }

    

}