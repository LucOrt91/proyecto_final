package com.portfolio.Lucas.Ortega.controller;

import com.portfolio.Lucas.Ortega.models.Experience;
import com.portfolio.Lucas.Ortega.services.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PutMapping("/update")
    public ResponseEntity<Experience> editExperience (@RequestBody Experience experience){
       Experience updateExperience = experienceService.editExperience(experience);
        return new ResponseEntity<>(updateExperience, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Experience>> getExperience(){
        List <Experience> experiences = experienceService.findExperience();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience){
        Experience newExperience = experienceService.addExperience(experience);
        return new ResponseEntity<>(newExperience, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable("id") Long id){
        experienceService.deleteExperience(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
