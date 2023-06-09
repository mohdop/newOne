package com.ism.exam.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable = false,unique = true)
    protected String roleName;
     @ManyToMany(mappedBy = "roles")
     List<Users> users;

    public UserRoles(String roleName) {
        this.roleName = roleName;
    }
    
}
