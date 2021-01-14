package com.example.person.domain;

import java.util.Collection;

public interface ReadPort {
    Collection<Person> listPeople();
}
