package com.ism.exam.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ListeDePresence")
@Data
@Setter
@Getter
public class ListeDePresence {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="etudiant_id")
    private Justification justification;

}
