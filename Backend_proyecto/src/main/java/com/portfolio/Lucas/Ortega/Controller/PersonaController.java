package com.portfolio.Lucas.Ortega.Controller;


import com.portfolio.Lucas.Ortega.Entity.Persona;
import com.portfolio.Lucas.Ortega.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "htttp://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg) {
        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setFotoPerfil(nuevoImg);

        iPersonaService.savePersona(persona);
        return persona;
    }
}

