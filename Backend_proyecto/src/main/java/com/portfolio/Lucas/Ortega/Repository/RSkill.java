package com.portfolio.Lucas.Ortega.Repository;

import com.portfolio.Lucas.Ortega.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RSkill extends JpaRepository<Skill, Integer> {
    public Optional<Skill> findByNombreSkill(String nombreSkill);
    public boolean existsByNombreSkill(String nombreSkill);
}
