package com.zoologia.animales.service;

import com.zoologia.animales.common.NotFoundException;
import com.zoologia.animales.common.ServiceException;
import com.zoologia.animales.domain.Animal;
import com.zoologia.animales.repository.AnimalesEntity;
import com.zoologia.animales.repository.AnimalesRepository;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalesRepository animalesRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalService.class);

    public Boolean createAnimal(Animal animal){

        try{
            AnimalesEntity animalesEntity = AnimalesEntity.builder()
                    .animalid(UUID.randomUUID().toString())
                    .familia(animal.getFamilia())
                    .nombre_comun(animal.getNombre_comun())
                    .phylum(animal.getPhylum())
                    .build();
            animalesRepository.save(animalesEntity);
            return true;

        }catch (Exception e){
            LOGGER.error(this.getClass().getName());
            LOGGER.error("createAnimal");
            LOGGER.error(e.getMessage());
            throw new ServiceException("ServiceError", e.getMessage(), e);
        }
    }

    public Animal getAnimal(String animalId){
        try{
            Optional<AnimalesEntity> optionalAnimalesEntity = animalesRepository.findByAnimalid(animalId);
            if (optionalAnimalesEntity.isPresent()){
                AnimalesEntity animalesEntity  = optionalAnimalesEntity.get();
                /*
                Animal animal = new Animal();
                animal.setAnimalid(animalesEntity.getAnimalid());
                animal.setFamilia(animalesEntity.getFamilia());
                animal.setNombre_comun(animalesEntity.getNombre_comun());
                animal.setPhylum(animalesEntity.getPhylum());
                  */
                return Animal.builder()
                        .animalid(animalesEntity.getAnimalid())
                        .nombre_comun(animalesEntity.getNombre_comun())
                        .familia(animalesEntity.getPhylum())
                        .phylum(animalesEntity.getPhylum())
                        .build();
            }
            throw new NotFoundException("Not Found ", null, null);

        }catch (Exception e){
            LOGGER.error(this.getClass().getName());
            LOGGER.error("getAnimal");
            LOGGER.error(e.getMessage());
            throw new ServiceException("ServiceError", e.getMessage(), e);
        }
    }

    public List<Animal> getAnimals(){
        try{
            List<AnimalesEntity> animalesEntityList = animalesRepository.findAll();
            List<Animal> animalList = new ArrayList<>();
            for (AnimalesEntity animalEntity : animalesEntityList) {
                Animal animal = new Animal();
                animal.setAnimalid(animalEntity.getAnimalid());
                animal.setPhylum(animalEntity.getPhylum());
                animal.setNombre_comun(animalEntity.getNombre_comun());
                animal.setFamilia(animalEntity.getFamilia());
                animalList.add(animal);
            }
            return animalList;
        }catch (Exception e){
            LOGGER.error(this.getClass().getName());
            LOGGER.error("getAnimals");
            LOGGER.error(e.getMessage());
            throw new ServiceException("ServiceError", e.getMessage(), e);
        }
    }
}
