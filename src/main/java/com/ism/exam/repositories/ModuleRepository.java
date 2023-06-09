package com.ism.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ism.exam.entities.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    
    Module save(Module module);
}
