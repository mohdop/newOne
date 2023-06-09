package com.ism.exam.api.dto;

import com.ism.exam.entities.Cours;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursDto {

    private Long id;
    private String libelle;

    public CoursDto(Cours cours) {
        this.id = cours.getId();
        this.libelle = cours.getLibelle();
    }
}
