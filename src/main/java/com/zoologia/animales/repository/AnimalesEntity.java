package com.zoologia.animales.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;


@Entity
@Table(name = "animal", indexes= @Index(columnList = "animalid"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalesEntity {
    @Id
    @Column(nullable = false)
    private String animalid;

    @Column(nullable = false)
    private String nombre_comun;

    @Column(nullable = false)
    private String familia;

    @Column(nullable = false)
    private String phylum;

}
