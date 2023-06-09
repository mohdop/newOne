package com.ism.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ism.exam.entities.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
    UserRoles findByRoleName(String roleName);
}

