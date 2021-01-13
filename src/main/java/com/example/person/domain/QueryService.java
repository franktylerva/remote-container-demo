package com.example.person.domain;

import java.util.Collection;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QueryService {

    private ReadRepository repository;

    public Collection<Person> listPeople() {
        return repository.listPeople();
    }
    
}
