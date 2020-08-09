package com.demo.builder;

import com.demo.domain.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonBuilder {
    private Person person;

    public PersonBuilder start() {
        this.person = new Person();
        return this;
    }

    public PersonBuilder reset() {
        this.person = new Person();
        return this;
    }

    public PersonBuilder setPersonName(String name) {
        this.person.setFirstName(name);
        return this;
    }

    public PersonBuilder setPersonSecondName(String secondName) {
        this.person.setSecondName(secondName);
        return this;
    }

    public PersonBuilder setPersonSurname(String surname) {
        this.person.setSurname(surname);
        return this;
    }

    public Person build() {
        return this.person;
    }
}
