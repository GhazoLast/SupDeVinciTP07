package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AnimalEntity;
import com.example.demo.services.AnimalService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/rest/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/{id}")
    public AnimalEntity findOne(@PathVariable("id") Integer id) {
        return this.animalService.findById(id);
    }
    @GetMapping("/")
    public Collection<AnimalEntity> findAll() {
        return this.animalService.findAll();
    }

    @PutMapping("/{id}")
    public AnimalEntity updateAnimal(@RequestBody @Valid AnimalEntity updatedAnimal) {
        return this.animalService.update(updatedAnimal);
    }

    @PostMapping("/")
    public AnimalEntity createAnimal(@RequestBody @Valid AnimalEntity animalToCreate) {
        return this.animalService.create(animalToCreate);
    }
    
    @DeleteMapping("/delete/{id}")
    public Map<String,Boolean> deleteAnimal(@RequestBody @Valid Integer id) {
        return this.animalService.delete(id);
    }
}
