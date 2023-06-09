package com.ism.exam.repositories;


import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ism.exam.entities.Cours;
import com.ism.exam.entities.Etudiant;
import com.ism.exam.entities.Justification;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findOneById(Long id) ;
    Etudiant save(Etudiant etudiant);
    List<Etudiant> findByCours(Cours cours);
}
