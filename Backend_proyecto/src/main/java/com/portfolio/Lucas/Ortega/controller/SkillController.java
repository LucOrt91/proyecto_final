package com.portfolio.Lucas.Ortega.controller;

import com.portfolio.Lucas.Ortega.models.Experience;
import com.portfolio.Lucas.Ortega.models.Skill;
import com.portfolio.Lucas.Ortega.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    @PutMapping
    public ResponseEntity<Skill> editSkill (@RequestBody Skill skill){
        Skill updateSkill = skillService.editSkills(skill);
        return new ResponseEntity<>(updateSkill, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Skill>> getSkill(){
        List <Skill> skills = skillService.findSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill){
        Skill newSkill = skillService.addSkills(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id){
        skillService.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
