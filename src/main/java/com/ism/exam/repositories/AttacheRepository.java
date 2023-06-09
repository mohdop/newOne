package com.ism.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ism.exam.entities.*;


import org.springframework.stereotype.Repository;

@Repository
public interface AttacheRepository extends JpaRepository<Users,Long> {
    List<Users> findByRoles(String roles);
    Attache findOneByAdresseEmailAndMotDePasse(String mail, String password );
    
}
