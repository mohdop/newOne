package com.ism.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ism.exam.entities.Cours;
import com.ism.exam.entities.Professeur;

import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

    List<Cours> findAll();
    List<Cours> findByProfesseur( Professeur professeur);
    Cours save(Cours cours);
    

}
