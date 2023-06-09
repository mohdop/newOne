package com.ism.exam.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ism.exam.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByadresseEmailAndMotDePasse(String email,String password);

}
