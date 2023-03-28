package ru.ivashkevich.firstrestapp.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivashkevich.firstrestapp.models.Person;
import ru.ivashkevich.firstrestapp.repositories.PeopleRepository;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> getAllPeople(){
        return peopleRepository.findAll();
    }

    public Person getPersonById(int id){
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional
    public void create(Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }
}
