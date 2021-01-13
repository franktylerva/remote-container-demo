package com.example.person.domain;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.person.adapters.db.PersonRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QueryService {

    private PersonRepository repository;

    public Collection<Person> listPeople() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
            .map( pe -> {
                return new Person(pe.getId(), pe.getName());
            }).collect(Collectors.toList());
    }
    
}
