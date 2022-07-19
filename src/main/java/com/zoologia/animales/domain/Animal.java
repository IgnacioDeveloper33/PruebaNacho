package com.zoologia.animales.domain;

import lombok.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    private String animalid;
    private String nombre_comun;
    private String familia;
    private String phylum;

}
