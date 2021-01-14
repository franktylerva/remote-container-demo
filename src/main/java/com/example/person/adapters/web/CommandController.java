package com.example.person.adapters.web;

import java.net.URI;

import com.example.person.domain.CommandPort;
import com.example.person.domain.Person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommandController {
    
    private final CommandPort commandPort;

    @PostMapping("/people")
    public ResponseEntity<Person> savePerson( @RequestBody Person person ) {

        Person savedPerson = commandPort.createPerson(person);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(savedPerson.getId());

        return ResponseEntity
                .created(location)
                .body(savedPerson);
    }

}
