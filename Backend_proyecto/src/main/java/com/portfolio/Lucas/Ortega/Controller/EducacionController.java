package com.portfolio.Lucas.Ortega.Controller;

import com.portfolio.Lucas.Ortega.Entity.Educacion;
import com.portfolio.Lucas.Ortega.Service.IEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducacionController {

    @Autowired
    IEducacionService iEducacionService;

    @GetMapping("/educaciones/traer")
    public List<Educacion> getEducacion(){
        return iEducacionService.getEducacion();
    }

    @PostMapping("/educaciones/crear")
    public String createEducacion(@RequestBody Educacion educacion){
        iEducacionService.saveEducacion(educacion);
        return "La educacion fue creada correctamente";
    }
    @DeleteMapping("/educaciones/borrar/{id}")
    public String deleteEducaciones(@PathVariable Long id){
        iEducacionService.deleteEducacion(id);
        return "La educacion fue eliminada correctamente";
    }
    @PutMapping("/educaciones/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
                                   @RequestParam("nombre") String nuevoNombre,
                                   @RequestParam("fecha") String nuevaFecha,
                                   @RequestParam("img") String nuevoImg){
        Educacion educacion = iEducacionService.findEducacion(id);
        educacion.setNombreEdu(nuevoNombre);
        educacion.setFechaEdu(nuevaFecha);
        educacion.setImgEdu(nuevoImg);

        iEducacionService.saveEducacion(educacion);
        return educacion;
    }

}