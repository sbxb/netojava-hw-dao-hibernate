package ru.netology.springHibernate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springHibernate.exception.PersonNotFound;
import ru.netology.springHibernate.model.Person;
import ru.netology.springHibernate.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/by-city")
    public Person getPersonByCity(@RequestParam("city") String city) {
        var person = repo.getPersonsByCity(city);
        if (person == null) {
            throw new PersonNotFound("No person in " + city + " was found");
        }
        return person;
    }

    @ExceptionHandler(PersonNotFound.class)
    public ResponseEntity<String> invalidCredentialsHandler(PersonNotFound e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
