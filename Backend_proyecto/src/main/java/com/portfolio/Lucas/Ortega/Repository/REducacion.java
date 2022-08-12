package com.portfolio.Lucas.Ortega.Repository;

import com.portfolio.Lucas.Ortega.Entity.Educacion;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface REducacion extends JpaRepository <Educacion, Integer> {
    public Optional<Educacion> findByNombreEdu(String nombreEdu);
    public boolean existsByNombreEdu(String nombreEdu);
}
