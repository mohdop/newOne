package com.ism.exam.entities;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "classe")

public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "libelle")
    private String libelle;

    @Column(name = "niveau")
    private String niveau;

    @Column(name = "filiere")
    private String filiere;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="etudiant_id")
    private List<Etudiant> etudiants;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salle_id")
    private SalleDeCours salleDeCours;

}
