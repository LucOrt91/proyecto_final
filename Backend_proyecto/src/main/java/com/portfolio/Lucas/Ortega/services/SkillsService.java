package com.portfolio.Lucas.Ortega.services;

import com.portfolio.Lucas.Ortega.models.Skills;
import com.portfolio.Lucas.Ortega.repository.SkillsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillsService {
    private final SkillsRepo skillsRepo;

    public SkillsService(SkillsRepo skillsRepo) {
        this.skillsRepo = skillsRepo;
    }
    public Skills addSkills(Skills skills){
        return skillsRepo.save(skills);
    }
    public List<Skills> findSkills(){
        return skillsRepo.findAll();
    }
    public Skills editSkills(Skills skills){
        return skillsRepo.save(skills);
    }
    public void deleteSkills(Long id){
        skillsRepo.deleteById(id);
    }
}
