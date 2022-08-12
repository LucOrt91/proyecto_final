package com.lucasnortegaportfolio.lucas.n.ortega.Controller;


import com.portfolio.Lucas.Ortega.Dto.dtoExperiencia;
import com.portfolio.Lucas.Ortega.Dto.dtoProyecto;
import com.portfolio.Lucas.Ortega.Entity.Proyecto;
import com.portfolio.Lucas.Ortega.Security.controller.Mensaje;
import com.portfolio.Lucas.Ortega.Service.SExperiencia;
import com.portfolio.Lucas.Ortega.Service.SProyecto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int idPro){
        if(!sProyecto.existsById(idPro))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(idPro).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int idPro) {
        if (!sProyecto.existsById(idPro)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(idPro);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro){
        if(StringUtils.isBlank(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyecto.existsByNombrePro(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);

        Proyecto proyecto = new Proyecto(dtopro.getNombrePro(), dtopro.getDescripcionPro());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int idPro, @RequestBody dtoProyecto dtopro){
        //Validamos si existe el ID
        if(!sProyecto.existsById(idPro))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sProyecto.existsByNombrePro(dtopro.getNombrePro()) && sProyecto.getByNombrePro(dtopro.getNombrePro()).get().getIdPro() != idPro)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Proyecto proyecto = sProyecto.getOne(idPro).get();
        proyecto.setNombrePro(dtopro.getNombrePro());
        proyecto.setDescripcionPro((dtopro.getDescripcionPro()));

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}