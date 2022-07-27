package com.portfolio.Lucas.Ortega.Controller;


import com.portfolio.Lucas.Ortega.Entity.Experiencia;
import com.portfolio.Lucas.Ortega.Service.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExperienciaController {

    @Autowired
    IExperienciaService iExperienciaService;

    @GetMapping("/experiencias/traer")
    public List<Experiencia> getExperiencia(){

        return iExperienciaService.getExperiencia();
    }

    @PostMapping("/experiencias/crear")
    public String createExperiencias(@RequestBody Experiencia experiencia){
        iExperienciaService.saveExperiencia(experiencia);
        return "La experiencia fue creada correctamente";
    }
    @DeleteMapping("/experiencias/borrar/{id}")
    public String deleteExperiencias(@PathVariable Long id){
        iExperienciaService.deleteExperiencia(id);
        return "La experiencia fue eliminada correctamente";
    }
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                                       @RequestParam("nombre") String nuevoNombre,
                                       @RequestParam("descripcion") String nuevaDesc,
                                       @RequestParam("img") String nuevoImg){
        Experiencia experiencia = iExperienciaService.findExperiencia(id);
        experiencia.setNombreExp(nuevoNombre);
        experiencia.setDescExp(nuevaDesc);
        experiencia.setImgExp(nuevoImg);

        iExperienciaService.saveExperiencia(experiencia);
        return experiencia;
    }
