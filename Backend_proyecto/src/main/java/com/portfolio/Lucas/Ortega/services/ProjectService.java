package com.portfolio.Lucas.Ortega.services;

import com.portfolio.Lucas.Ortega.models.Project;
import com.portfolio.Lucas.Ortega.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }
    public Project addProject(Project project){
        return projectRepo.save(project);
    }
    public List<Project> findProject(){
        return projectRepo.findAll();
    }
    public Project editProject(Project project){
        return projectRepo.save(project);
    }
    public void deleteProject (Long id){
        projectRepo.deleteById(id);
    }
}
