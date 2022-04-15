package com.graigjin.localhostbackend.controller;

import com.graigjin.localhostbackend.model.Person;
import com.graigjin.localhostbackend.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
