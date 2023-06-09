package com.ism.exam.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "semestre")
@Data
@Setter
@Getter
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "dateDebut")
    private LocalDate dateDebut;

    @Column(name = "dateFin")
    private LocalDate dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anneescolaire_id")
    private AnneeScolaire anneescolaire_id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id")
    private List<Module>  modules;
}
