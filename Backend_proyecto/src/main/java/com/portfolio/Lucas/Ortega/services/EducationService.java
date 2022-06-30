package com.portfolio.Lucas.Ortega.services;

import com.portfolio.Lucas.Ortega.models.Education;
import com.portfolio.Lucas.Ortega.repository.EducationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducationService {
    private final EducationRepo educationRepo;

    @Autowired
    public EducationService(EducationRepo educationRepo) {
        this.educationRepo = educationRepo;
    }
    public Education addEducation(Education education){
        return educationRepo.save(education);
    }
    public List<Education> findEducation(){
        return educationRepo.findAll();
    }
    public Education editEducation(Education education){
        return educationRepo.save(education);
    }
    public void deleteEducation (Long id){
        educationRepo.deleteById(id);
    }
}
