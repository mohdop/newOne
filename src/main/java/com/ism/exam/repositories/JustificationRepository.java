package com.ism.exam.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ism.exam.entities.Justification;

public interface JustificationRepository extends JpaRepository<Justification, Long> {
    Justification findByEtudiantIdAndSessionId(Long etudiantId, Long sessionId);
    Justification findOneById(Long id) ;
}
