package com.ism.exam.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ism.exam.entities.*;


import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository  extends JpaRepository<Professeur,Long>{
    List<Professeur> findAll();
    Professeur findOneById(Long id);
    List<Professeur> findByAdresseEmailContaining(String mail);

}
