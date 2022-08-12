package com.portfolio.Lucas.Ortega.Controller;


import com.portfolio.Lucas.Ortega.Entity.Persona;
import com.portfolio.Lucas.Ortega.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/persona")
@CrossOrigin(origins = "htttp://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido) {
        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);


        iPersonaService.savePersona(persona);
        return persona;
    }
}

