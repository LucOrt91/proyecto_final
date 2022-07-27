package com.portfolio.Lucas.Ortega.Repository;

import com.portfolio.Lucas.Ortega.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillsRepo extends JpaRepository<Skill, Long> {
}
