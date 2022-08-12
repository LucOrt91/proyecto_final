package com.portfolio.Lucas.Ortega.Repository;

import com.portfolio.Lucas.Ortega.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNombreExp(String nombreExp);
    public boolean existsByNombreExp(String nombreExp);
}
