package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AnimalEntity;
import com.example.demo.repositories.AnimalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public AnimalEntity create(@Valid AnimalEntity animalToCreate) {
        return this.animalRepository.save(animalToCreate);
    }

    public AnimalEntity update(@Valid AnimalEntity updatedAnimal) {
        return this.animalRepository.save(updatedAnimal);
    }

    public Collection<AnimalEntity> findAll() {
        return this.animalRepository.findAll();
    }
    
    public AnimalEntity findById(Integer id) {
        return this.animalRepository.findById(id);
    }
}
