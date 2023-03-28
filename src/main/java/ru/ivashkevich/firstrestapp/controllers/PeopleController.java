package ru.ivashkevich.firstrestapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivashkevich.firstrestapp.models.Person;
import ru.ivashkevich.firstrestapp.services.PeopleService;
import ru.ivashkevich.firstrestapp.util.PersonErrorResponse;
import ru.ivashkevich.firstrestapp.util.PersonNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return peopleService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id){
        return peopleService.getPersonById(id);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException ex){
        PersonErrorResponse response = new PersonErrorResponse("Person with this id wasn't found!", System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
