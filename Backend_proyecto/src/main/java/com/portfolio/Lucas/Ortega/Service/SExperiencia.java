package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Experiencia;
import com.portfolio.Lucas.Ortega.Repository.RExperiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;

    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }

    public Optional<Experiencia> getOne(int idExp){
        return rExperiencia.findById(idExp);
    }

    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return rExperiencia.findByNombreExp(nombreExp);
    }

    public void save(Experiencia expe){
        rExperiencia.save(expe);
    }

    public void delete(int idExp){
        rExperiencia.deleteById(idExp);
    }

    public boolean existsById(int idExp){
        return rExperiencia.existsById(idExp);
    }

    public boolean existsByNombreExp(String nombreExp){
        return rExperiencia.existsByNombreExp(nombreExp);
    }
}