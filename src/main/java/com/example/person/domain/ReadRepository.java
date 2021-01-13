package com.example.person.domain;

import java.util.Collection;

public interface ReadRepository {
    Collection<Person> listPeople();
}
