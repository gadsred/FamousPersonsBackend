package com.example.famous_persons.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.famous_persons.model.Person;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Person, Integer> {

}