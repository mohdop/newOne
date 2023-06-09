package com.ism.exam.repositories;

import java.time.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ism.exam.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByProfesseurId(Long professeurId);
    Session findOneById(Long id);
    Session save(Session session);
    List<Session> findByProfesseurIdAndDateBetween(Long professeurId, LocalDateTime debut, LocalDateTime fin);
    List<Session> findByCoursId(Long coursId);
    List<Session> findByDate(LocalDate dat);

}
