package com.portfolio.Lucas.Ortega.Repository;

import com.portfolio.Lucas.Ortega.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepo extends JpaRepository<Persona, Long> {

}
