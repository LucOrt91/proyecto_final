package com.portfolio.Lucas.Ortega.Controller;

import com.portfolio.Lucas.Ortega.Dto.dtoEducacion;
import com.portfolio.Lucas.Ortega.Entity.Educacion;
import com.portfolio.Lucas.Ortega.Security.controller.Mensaje;
import com.portfolio.Lucas.Ortega.Service.SEducacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://lucasortegaportfolio-d1feb.web.app")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int idEdu){
        if(!sEducacion.existsById(idEdu)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(idEdu).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idEdu){
        if(!sEducacion.existsById(idEdu)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(idEdu);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoeducacion.getNombreEdu(), dtoeducacion.getDescripcionEdu());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idEdu, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(idEdu)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu()) && sEducacion.getByNmbreEdu(dtoeducacion.getNombreEdu()).get().getIdEdu() != idEdu){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(idEdu).get();

        educacion.setNombreEdu(dtoeducacion.getNombreEdu());
        educacion.setDescripcionEdu(dtoeducacion.getDescripcionEdu());

        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}