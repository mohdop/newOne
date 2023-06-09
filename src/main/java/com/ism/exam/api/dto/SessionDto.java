package com.ism.exam.api.dto;
import java.time.*;

import com.ism.exam.entities.Session;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {


    private Long id ;
    private LocalDate date ;
    private LocalTime heureDebut ;
    private LocalTime heureFin;
    private String etat ;

    public SessionDto(Session session) {
        this.id = session.getId();
        this.date = session.getDate();
        this.heureDebut = session.getHeureDebut();
        this.heureFin = session.getHeureFin();
        this.etat = session.getEtat();
    }
    
}
