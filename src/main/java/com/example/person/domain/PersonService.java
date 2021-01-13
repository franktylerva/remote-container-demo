package com.example.person.domain;

import com.example.person.adapters.db.PersonRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository repository;

    public Iterable<Person> listPeople() {
        return repository.findAll();
    }
    
}
