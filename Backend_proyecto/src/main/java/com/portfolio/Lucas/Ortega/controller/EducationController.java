package com.portfolio.Lucas.Ortega.controller;

import com.portfolio.Lucas.Ortega.models.Education;
import com.portfolio.Lucas.Ortega.services.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    private final EducationService educationService;

    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }
    @PutMapping("/update")
    public ResponseEntity<Education> editEducation(@RequestBody Education education){
        Education updateEducation = educationService.editEducation(education);
        return new ResponseEntity<>(updateEducation, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Education>> getEducation(){
        List <Education> educations = educationService.findEducation();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Education> addEducation(@RequestBody Education education){
        Education newEducation = educationService.addEducation(education);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") Long id){
        educationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
