package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.PersonEntity;
import com.example.demo.services.PersonService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/rest/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public PersonEntity findOne(@PathVariable("id") Integer id) {
        return this.personService.findById(id);
    }
    @GetMapping("/")
    public Collection<PersonEntity> findAll() {
        return this.personService.findAll();
    }

    @PutMapping("/{id}")
    public PersonEntity updatePerson(@RequestBody @Valid PersonEntity updatedPerson) {
        return this.personService.update(updatedPerson);
    }

    @PostMapping("/")
    public PersonEntity postMethodName(@RequestBody @Valid PersonEntity personToCreate) {
        return this.personService.create(personToCreate);
    }
    
    
}
