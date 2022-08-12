package com.portfolio.Lucas.Ortega.Security.repository;

import java.util.Optional;

import com.portfolio.Lucas.Ortega.Security.entity.Rol;
import com.portfolio.Lucas.Ortega.Security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}