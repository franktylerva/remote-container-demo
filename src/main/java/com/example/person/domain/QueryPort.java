package com.example.person.domain;

import java.util.Collection;

public interface QueryPort {
    Collection<Person> listPeople();
}
