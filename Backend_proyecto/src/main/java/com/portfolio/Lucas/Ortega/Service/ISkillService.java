package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Skill;
import com.portfolio.Lucas.Ortega.Repository.ISkillsRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ISkillService {
    private final ISkillsRepo ISkillsRepo;

    public ISkillService(ISkillsRepo ISkillsRepo) {
        this.ISkillsRepo = ISkillsRepo;
    }
    public Skill addSkills(Skill skill){
        return ISkillsRepo.save(skill);
    }
    public List<Skill> findSkills(){
        return ISkillsRepo.findAll();
    }
    public Skill editSkills(Skill skill){
        return ISkillsRepo.save(skill);
    }
    public void deleteSkills(Long id){
        ISkillsRepo.deleteById(id);
    }
}
