package com.ism.exam.entities;

import java.time.*;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "session")

public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateSession")
    private LocalDate date;

    @Column(name = "heure_debut")
    private LocalTime heureDebut;

    @Column(name = "heure_fin")
    private LocalTime heureFin;

    @Column(name = "etat")
    private String etat;

    public String getEtat() {
        return etat;
    }


    public void setEtat(String etat) {
        this.etat = etat;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cours_id")
    private Cours cours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="etudiant_id")
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presence_id")
    private Presence presence;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="justification_id")
    private List<Justification>  justification;
    

    public Presence getPresence() {
        return presence;
    }


    public void setPresence(Presence presence) {
        this.presence = presence;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalTime getHeureDebut() {
        return heureDebut;
    }


    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }


    public LocalTime getHeureFin() {
        return heureFin;
    }


    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }


    public Cours getCours() {
        return cours;
    }


    public void setCours(Cours cours) {
        this.cours = cours;
    }


    public Professeur getProfesseur() {
        return professeur;
    }


    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }


    // Getters and setters

}
