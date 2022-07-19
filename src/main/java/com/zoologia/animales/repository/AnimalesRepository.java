package com.zoologia.animales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalesRepository extends JpaRepository<AnimalesEntity, String>  {

    Optional<AnimalesEntity> findByAnimalid(String animalid);

}
