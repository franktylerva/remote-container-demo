package com.example.person.adapters.web;

import com.example.person.domain.Person;
import com.example.person.domain.QueryPort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {
    
    @Autowired
    private QueryPort queryPort;

    @GetMapping("/people")
    public Iterable<Person> listPeople() {
        return queryPort.listPeople();
    }

}
