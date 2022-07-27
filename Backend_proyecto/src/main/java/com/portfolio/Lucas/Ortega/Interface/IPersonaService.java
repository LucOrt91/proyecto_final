package com.portfolio.Lucas.Ortega.Interface;

import com.portfolio.Lucas.Ortega.Entity.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersona();
    public void savePersona(Persona persona);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
}
