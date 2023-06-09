package com.ism.exam.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cours")

public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "libelle")
    private String libelle;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id")
    private List<Module>  modules;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="etudian_id")
    private List<Etudiant>  etudiants;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="session_id")
    private List<Session>  sessions;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        return "Cours [libelle=" + libelle + ", professeur=" + professeur + "]";
    }
}
