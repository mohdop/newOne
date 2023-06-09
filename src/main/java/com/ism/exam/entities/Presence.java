package com.ism.exam.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Presence")
@Data
@Setter
@Getter
public class Presence {
    
    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;


    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    
    @JoinColumn(name="etat")
    private String etat;

    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="justification_id")
    private Justification justification;
    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    
}