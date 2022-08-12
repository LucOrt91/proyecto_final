package com.lucasnortegaportfolio.lucas.n.ortega.Controller;


import com.portfolio.Lucas.Ortega.Dto.dtoSkill;
import com.portfolio.Lucas.Ortega.Entity.Skill;
import com.portfolio.Lucas.Ortega.Security.controller.Mensaje;
import com.portfolio.Lucas.Ortega.Service.SSkill;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkill {
    @Autowired
    SSkill sSkill;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int idSkill){
        if(!sSkill.existsById(idSkill))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.getOne(idSkill).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idSkill) {
        if (!sSkill.existsById(idSkill)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSkill.delete(idSkill);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNombreSkil()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreSkill(dtoSkill.getNombreSkil()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(dtoSkill.getNombreSkil(), dtoSkill.getImagenSkill(), dtoSkill.getNivelSkill());
        sSkill.save(skill);


        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idSkill, @RequestBody dtoSkill dtoSkill){
        //Validamos si existe el ID
        if(!sSkill.existsById(idSkill))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sSkill.existsByNombreSkill(dtoSkill.getNombreSkil()) && sSkill.getByNombreSkill(dtoSkill.getNombreSkil()).get().getIdSkill() != idSkill)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoSkill.getNombreSkil()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            Skill skill = sSkill.getOne(idSkill).get();
            skill.setNombreSkill(dtoSkill.getNombreSkil());
            skill.setNivelSkill(dtoSkill.getNivelSkill());

            sSkill.save(skill);
            return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
        }
    }