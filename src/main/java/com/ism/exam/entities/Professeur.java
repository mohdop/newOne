package com.ism.exam.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "professeur")
@DiscriminatorValue(value = "PROFESSEUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Professeur extends Users {

    @Column(name = "specialite")
    private String specialite;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="cours_id")
    private List<Cours>  cours;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="session_id")
    private List<Session>  sessions;

    

    public Professeur(Long id) {
        super(id);
    }
}
