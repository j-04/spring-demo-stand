package com.demo.controller;

import com.demo.domain.HttpError;
import com.demo.domain.Person;
import com.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public ResponseEntity<?> getPersons() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        try {
            Person person = personRepository.getOne(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception ex) {
            return badRequest(ex);
        }
    }

    private ResponseEntity<?> badRequest(Throwable ex) {
        ex.printStackTrace();
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new HttpError(badRequest.value(), "Bad request"), badRequest);
    }
}
