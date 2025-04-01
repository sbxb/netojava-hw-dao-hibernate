package ru.netology.springHibernate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springHibernate.exception.PersonNotFound;
import ru.netology.springHibernate.model.Person;
import ru.netology.springHibernate.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        var persons = repo.findByCityOfLivingIgnoreCase(city);
        if (persons.isEmpty()) {
            throw new PersonNotFound("No person in " + city + " was found");
        }
        return persons;
    }

    @ExceptionHandler(PersonNotFound.class)
    public ResponseEntity<String> absentPersonHandler(PersonNotFound e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
