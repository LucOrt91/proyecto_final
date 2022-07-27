package com.portfolio.Lucas.Ortega.Service;


import com.portfolio.Lucas.Ortega.Entity.Persona;
import com.portfolio.Lucas.Ortega.Interface.IPersonaService;
import com.portfolio.Lucas.Ortega.Repository.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired
    IPersonaRepo iPersonaRepo;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepo.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRepo.findById(id).orElse(null);
        return persona;
    }
}
