package com.portfolio.Lucas.Ortega.services;

import com.portfolio.Lucas.Ortega.models.Experience;
import com.portfolio.Lucas.Ortega.repository.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExperienceService {
    private final ExperienceRepo experienceRepo;

    @Autowired
    public ExperienceService(ExperienceRepo experienceRepo) {
        this.experienceRepo = experienceRepo;
    }
    public Experience addExperience(Experience experience){
        return experienceRepo.save(experience);
    }
    public List<Experience> findExperience(){
        return experienceRepo.findAll();
    }
    public Experience editExperience(Experience experience){
        return experienceRepo.save(experience);
    }
    public void deleteExperience(Long id){
        experienceRepo.deleteById(id);
    }
}
