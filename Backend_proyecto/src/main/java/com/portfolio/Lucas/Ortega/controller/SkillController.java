package com.portfolio.Lucas.Ortega.controller;

import com.portfolio.Lucas.Ortega.models.Experience;
import com.portfolio.Lucas.Ortega.models.Skill;
import com.portfolio.Lucas.Ortega.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    @PutMapping("/update")
    public ResponseEntity<Skill> editSkill (@RequestBody Skill skill){
        Skill updateSkill = skillService.editSkills(skill);
        return new ResponseEntity<>(updateSkill, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Skill>> getSkill(){
        List <Skill> skills = skillService.findSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill){
        Skill newSkill = skillService.addSkills(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id){
        skillService.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
