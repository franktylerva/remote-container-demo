package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
public class DefaultController {
    
    @Autowired
    private PersonRepository repository;

    @GetMapping("/")
    public Iterable<Person> index() {
        return repository.findAll();
    }

}
