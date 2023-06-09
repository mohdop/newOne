package com.ism.exam.entities;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "salleDeCours")

public class SalleDeCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero")
    private String libelle;

    @Column(name = "capacite")
    private Long capacite;


    @Column(name = "etat")
    private String etat;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="etudiant_id")
    private List<Classe> classes;
}
