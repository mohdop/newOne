package com.ism.exam.entities;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="attache")
@DiscriminatorValue(value = "Attache")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Attache extends Users {
   
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    // Constructeurs, getters et setters
}
