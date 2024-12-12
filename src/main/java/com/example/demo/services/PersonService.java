package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PersonEntity;
import com.example.demo.repositories.PersonRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public PersonEntity create(@Valid PersonEntity personToCreate) {
        return this.personRepository.save(personToCreate);
    }

    public PersonEntity update(@Valid PersonEntity updatedPerson) {
        return this.personRepository.save(updatedPerson);
    }

    public Collection<PersonEntity> findAll() {
        return this.personRepository.findAll();
    }
    
    public PersonEntity findById(Integer id) {
        return this.personRepository.findById(id);
    }
}