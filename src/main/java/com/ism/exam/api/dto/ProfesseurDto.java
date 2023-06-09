package com.ism.exam.api.dto;

import com.ism.exam.entities.Professeur;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurDto {

    private Long id;
    private String nomComplet;
    private String adresseEmail;
    private String motDePasse;

    public ProfesseurDto(Professeur professeur) {
        id = professeur.getId();
        nomComplet = professeur.getNomComplet();
        adresseEmail = professeur.getAdresseEmail();
        motDePasse = professeur.getMotDePasse();
    }
    
}
