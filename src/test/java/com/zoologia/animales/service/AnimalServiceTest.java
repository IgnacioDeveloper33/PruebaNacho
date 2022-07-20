package com.zoologia.animales.service;


import com.zoologia.animales.repository.AnimalesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    @Mock private AnimalesRepository animalesRepository;

    @InjectMocks private AnimalService animalService;

    @Test
    public void shouldCreateAnimal(){

    }
}