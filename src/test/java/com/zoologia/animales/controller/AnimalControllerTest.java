package com.zoologia.animales.controller;


import com.zoologia.animales.domain.Animal;
import com.zoologia.animales.service.AnimalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AnimalControllerTest {

    @Mock private AnimalService animalService;
    @InjectMocks private AnimalController animalController;

    @Test
    public void shouldCreateAnimal(){
        Mockito.when(animalService.createAnimal(Mockito.any())).thenReturn(true);
        Animal animal = new Animal();
        animal.setFamilia("familiaprueba");
        animal.setNombre_comun("nombrecomun prueba");
        animal.setPhylum("phylum prueba");
        animal.setAnimalid("123");
        ResponseEntity<Boolean> response = animalController.createAnimal(animal);
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.getBody());
    }

    @Test
    public void shouldGetAnimal(){
        Mockito.when(animalService.getAnimal(Mockito.any())).thenReturn(new Animal());
        ResponseEntity<Animal> response = animalController.getAnimal("123");
        Assertions.assertNotNull(response);
    }

    @Test
    public void shouldGetAnimals(){
        Mockito.when(animalService.getAnimals()).thenReturn(Arrays.asList(new Animal()));
        ResponseEntity<List<Animal>> response = animalController.getAnimals();
        Assertions.assertNotNull(response);
    }

    @Test
    public void shouldUpdateAnimal(){
        Mockito.when(animalService.updateAnimal(Mockito.any())).thenReturn(true);
        ResponseEntity<Boolean> response = animalController.updateAnimal(new Animal());
        Assertions.assertNotNull(response);
    }

    @Test
    public void shouldDeleteAnimalById(){
        Mockito.when(animalService.updateAnimal(Mockito.any())).thenReturn(true);
        ResponseEntity<Boolean> response = animalController.updateAnimal(new Animal());
        Assertions.assertNotNull(response);
    }
}