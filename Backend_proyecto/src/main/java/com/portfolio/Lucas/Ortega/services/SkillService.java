package com.portfolio.Lucas.Ortega.services;

import com.portfolio.Lucas.Ortega.models.Skill;
import com.portfolio.Lucas.Ortega.repository.SkillsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillService {
    private final SkillsRepo skillsRepo;

    public SkillService(SkillsRepo skillsRepo) {
        this.skillsRepo = skillsRepo;
    }
    public Skill addSkills(Skill skill){
        return skillsRepo.save(skill);
    }
    public List<Skill> findSkills(){
        return skillsRepo.findAll();
    }
    public Skill editSkills(Skill skill){
        return skillsRepo.save(skill);
    }
    public void deleteSkills(Long id){
        skillsRepo.deleteById(id);
    }
}
