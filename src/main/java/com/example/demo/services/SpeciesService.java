package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.SpecieEntity;
import com.example.demo.repositories.SpeciesRepository;

import jakarta.validation.Valid;

@Service
public class SpeciesService {
    @Autowired
    SpeciesRepository speciesRepository;

    public SpecieEntity create(@Valid SpecieEntity speciesToCreate) {
        return this.speciesRepository.save(speciesToCreate);
    }

    public SpecieEntity update(@Valid SpecieEntity updatedAnimal) {
        return this.speciesRepository.save(updatedAnimal);
    }

    public String delete(@Valid @PathVariable(value = "id") Integer speciesId) {
		SpecieEntity species = this.speciesRepository.findById(speciesId);
		this.speciesRepository.delete(species);
        return "Espèce supprimée";
	}

    public Collection<SpecieEntity> findAll() {
        return this.speciesRepository.findAll();
    }
    
    public SpecieEntity findById(Integer id) {
        return this.speciesRepository.findById(id);
    }
}
