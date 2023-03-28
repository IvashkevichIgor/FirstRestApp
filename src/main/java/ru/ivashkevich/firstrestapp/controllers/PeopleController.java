package ru.ivashkevich.firstrestapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ivashkevich.firstrestapp.models.Person;
import ru.ivashkevich.firstrestapp.services.PeopleService;

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
}
