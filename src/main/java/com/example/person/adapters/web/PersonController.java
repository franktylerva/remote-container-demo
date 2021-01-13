package com.example.person.adapters.web;

import com.example.person.adapters.db.PersonRepository;
import com.example.person.core.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    
    @Autowired
    private PersonRepository repository;

    @GetMapping("/")
    public Iterable<Person> index() {
        return repository.findAll();
    }

}
