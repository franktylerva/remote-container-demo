package com.example.person.adapters.db;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.person.domain.Person;
import com.example.person.domain.ReadRepository;
import com.example.person.domain.WriteRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PersonRepository extends CrudRepository<PersonEntity,Long>, ReadRepository, WriteRepository {
    
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

}
