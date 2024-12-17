package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.SpecieEntity;
import com.example.demo.services.SpeciesService;

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
@RequestMapping("/rest/species")
public class SpeciesController {

    @Autowired
    SpeciesService speciesService;

    @GetMapping("/{id}")
    public SpecieEntity findOne(@PathVariable("id") Integer id) {
        return this.speciesService.findById(id);
    }
    @GetMapping("/")
    public Collection<SpecieEntity> findAll() {
        return this.speciesService.findAll();
    }

    @PutMapping("/")
    public SpecieEntity updatePerson(@RequestBody @Valid SpecieEntity updatedPerson) {
        return this.speciesService.update(updatedPerson);
    }

    @PostMapping("/")
    public SpecieEntity postMethodName(@RequestBody @Valid SpecieEntity speciesToCreate) {
        return this.speciesService.create(speciesToCreate);
    }
    
    @DeleteMapping("/{id}")
    public String deletePerson(@Valid @PathVariable("id") Integer id) {
        return this.speciesService.delete(id);
    }
    
}
