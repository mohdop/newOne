package com.ism.exam.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ism.exam.entities.*;


import org.springframework.stereotype.Repository;



@Repository
public interface ResponsablePedagogiqueRepository  extends JpaRepository<ResponsablePedagogique,Long> {
    SalleDeCours save(SalleDeCours  salleDeCours);
}
