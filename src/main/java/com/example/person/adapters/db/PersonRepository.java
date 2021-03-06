package com.example.person.adapters.db;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.person.domain.Person;
import com.example.person.domain.QueryPort;
import com.example.person.domain.CommandPort;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
interface PersonRepository extends CrudRepository<PersonRepository.PersonEntity,Long>, QueryPort, CommandPort {
    
    @Override
    default Collection<Person> listPeople() { 
        return StreamSupport.stream(findAll().spliterator(), false)
            .map( pe -> {
                return new Person(pe.getId(), pe.getName());
            }).collect(Collectors.toList());
    }

    @Override
    default Person createPerson(Person person) {
        PersonEntity entity = new PersonEntity(person.getName());
        entity = save(entity);
        return new Person(entity.getId(), entity.getName());
    }

    @Entity
    @Data
    @NoArgsConstructor
    class PersonEntity {
        
        public PersonEntity(String name) {
            this.name = name;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        
        @Column(name = "USERNAME")
        String name;
    }

}
