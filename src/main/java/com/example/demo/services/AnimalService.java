package com.example.demo.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public Map<String, Boolean> delete(@Valid @PathVariable(value = "id") Integer animalId) {
		AnimalEntity animal = animalRepository.findById(animalId);
		animalRepository.delete(animal);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

    public Collection<AnimalEntity> findAll() {
        return this.animalRepository.findAll();
    }
    
    public AnimalEntity findById(Integer id) {
        return this.animalRepository.findById(id);
    }
}
