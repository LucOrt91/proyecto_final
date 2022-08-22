package com.portfolio.Lucas.Ortega.Controller;

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
@CrossOrigin(origins = "https://lucasortegaporfolio.web.app")
public class CSkill {

    @Autowired
    SSkill sSkill;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int idSkill) {
        if (!sSkill.existsById(idSkill)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreSkill(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Esa Skill existe"), HttpStatus.BAD_REQUEST);

       Skill skill = new Skill(dtoskill.getNombreSkill(), dtoskill.getImgSkill(), dtoskill.getNivelSkill());
       sSkill.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idSkill, @RequestBody dtoSkill dtoskill) {
//Validamos si existe el ID
        if (!sSkill.existsById(idSkill)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
//Compara nombre de Skill
        if (sSkill.existsByNombreSkill(dtoskill.getNombreSkill()) && sSkill.getByNombreSkill(dtoskill.getNombreSkill()).get().getIdSkill() != idSkill) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
//No puede estar vacio
        if (StringUtils.isBlank(dtoskill.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = sSkill.getOne(idSkill).get();
        skill.setNombreSkill(dtoskill.getNombreSkill());
        skill.setImgSkill(dtoskill.getImgSkill());
        skill.setNivelSkill(dtoskill.getNivelSkill());

        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}
