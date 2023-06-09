package com.ism.exam.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ism.exam.entities.SalleDeCours;



@Repository
public interface SalleDeCoursRepository extends JpaRepository<SalleDeCours, Long> {
    
    SalleDeCours save(SalleDeCours salleDeCours);
}

