package com.portfolio.Lucas.Ortega.controller;


import com.portfolio.Lucas.Ortega.models.Project;
import com.portfolio.Lucas.Ortega.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PutMapping("/update")
    public ResponseEntity<Project> editProject (@RequestBody Project project){
        Project updateProject = projectService.editProject(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getProject(){
        List<Project> projects = projectService.findProject();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id){
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}