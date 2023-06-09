package com.ism.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ism.exam.entities.*;

public interface PresenceRepository extends JpaRepository<Presence, Long> {
    List<Presence> findByEtudiantAndSession(Etudiant etudiant, Session session);
    List<Presence> findBySession(Session session);
    Presence findOneBySession(Session session);
    Presence findByEtudiant(Etudiant etudiant);
    Presence save(Presence presence);
    Presence findOneById(Long id);
   

}
