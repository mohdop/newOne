package com.ism.exam.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "etudiant")
@DiscriminatorValue(value = "Etudiant")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Etudiant extends Users {


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="session_id")
    private List<Session>  sessions;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="cours")
    private List<Cours>  cours;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="justification_id")
    private List<Justification>  justification;
    
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Presence> presences;



}
