package com.lucasnortegaportfolio.lucas.n.ortega.Controller;


import com.portfolio.Lucas.Ortega.Service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProyectoController {

    @Autowired
    IProyectoService iProyectoService;

    @GetMapping("/proyectos/traer")
    public List<Proyecto> getProyecto(){
        return iProyectoService.getProyecto();
    }

    @PostMapping("/proyectos/crear")
    public String createProyecto(@RequestBody Proyecto proyecto){
        iProyectoService.saveProyecto(proyecto);
        return "El proyecto fue creado correctamente";
    }
    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id){
        iProyectoService.deleteProyecto(id);
        return "El proyecto fue eliminado correctamente";
    }
    @PutMapping("/proyectos/editar/{id}")
    public Proyecto editProyecto(@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("descripcion") String nuevaDesc,
                                 @RequestParam("img") String nuevoImg){
        Proyecto proyecto = iProyectoService.findProyecto(id);
        proyecto.setTituloPro(nuevoNombre);
        proyecto.setDescrPro(nuevaDesc);
        proyecto.setImgPro(nuevoImg);

        iProyectoService.saveProyecto(proyecto);
        return proyecto;
    }

}