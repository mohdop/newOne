package com.ism.exam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "module")
@Data
@Setter
@Getter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cours_id")
    private Cours cours;
    
}
