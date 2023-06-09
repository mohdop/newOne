package com.ism.exam.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@DiscriminatorValue(value = "USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name="adresse_email",nullable = false)
    protected String adresseEmail;

    @Column(name="motDePasse")
    protected String motDePasse;

    @Column(name="nomComplet")
    protected String nomComplet;

    public Users(Long id) {
        this.id = id;
    }

    public Users(Long id, String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    List<UserRoles> roles=new ArrayList<>();

}
