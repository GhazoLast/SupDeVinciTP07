package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.AnimalEntity;
import com.example.demo.repositories.AnimalRepository;

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

    public String delete(@Valid @PathVariable(value = "id") Integer animalId) {
		AnimalEntity animal = this.animalRepository.findById(animalId);
		this.animalRepository.delete(animal);
        return "Animal supprimé";
	}

    public Collection<AnimalEntity> findAll() {
        return this.animalRepository.findAll();
    }
    
    public AnimalEntity findById(Integer id) {
        return this.animalRepository.findById(id);
    }
}
