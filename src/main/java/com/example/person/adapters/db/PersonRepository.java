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
import com.example.person.domain.ReadPort;
import com.example.person.domain.WritePort;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
interface PersonRepository extends CrudRepository<PersonRepository.PersonEntity,Long>, ReadPort, WritePort {
    
    @Override
    default Collection<Person> listPeople() { 
        return StreamSupport.stream(findAll().spliterator(), false)
            .map( pe -> {
                return new Person(pe.getId(), pe.getName());
            }).collect(Collectors.toList());
    }

    @Override
    default Long createPerson(Person person) {
        PersonEntity entity = new PersonEntity(person.getName());
        return save(entity).getId();
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
