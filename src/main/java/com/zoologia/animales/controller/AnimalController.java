package com.zoologia.animales.controller;

import com.zoologia.animales.domain.Animal;
import com.zoologia.animales.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalController.class);

    @PutMapping(value = "/animal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createAnimal(@RequestBody Animal animal){
        LOGGER.info("Create Animal");
        return ResponseEntity.ok().body(animalService.createAnimal(animal));
    }

    @GetMapping(value = "/animal/{animalId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Animal> getAnimal(@PathVariable String animalId){
        LOGGER.info("Obteniendo Animal");
        return ResponseEntity.ok().body(animalService.getAnimal(animalId));
    }

    @GetMapping(value = "/animal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Animal>> getAnimals(){
        LOGGER.info("Obteniendo Animal");
        return ResponseEntity.ok().body(animalService.getAnimals());
    }

    @PostMapping(value = "/animal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateAnimal(@RequestBody Animal animal){
        LOGGER.info("Update Animal");
        return ResponseEntity.ok().body(animalService.updateAnimal(animal));
    }

    @DeleteMapping(value = "/animal/{animalId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteAnimalById(@PathVariable String animalId){
        LOGGER.info("Delete Animal");
        return ResponseEntity.ok().body(animalService.deleteAnimalById(animalId));
    }
}
