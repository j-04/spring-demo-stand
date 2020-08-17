package com.demo.util;

import com.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.demo.builder.PersonBuilder;
import com.demo.domain.Person;

import javax.transaction.Transactional;

@Component
@Profile("dev")
public class DevDataInitializer implements DataInitializer {
    private PersonRepository personRepository;
    private PersonBuilder personBuilder;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    public void setPersonBuilder(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void insertPersonsToDataBase() {
        Person person1 = personBuilder.start()
                .setPersonName("Mark")
                .setPersonSurname("Zukerberg")
                .setPersonSecondName("Jr.")
                .build();

        Person person2 = personBuilder.reset()
                .setPersonName("Hovard")
                .setPersonSurname("Stark")
                .setPersonSecondName("Gr.")
                .build();

        Person person3 = personBuilder.reset()
                .setPersonName("Tony")
                .setPersonSurname("Stark")
                .setPersonSecondName("Jr.")
                .build();

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
    }
}
