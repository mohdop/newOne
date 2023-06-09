package com.ism.exam.entities;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "responsable_pedagogique")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "ResponsablePedagogique")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponsablePedagogique extends Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
