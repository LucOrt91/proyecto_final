package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Experiencia;
import com.portfolio.Lucas.Ortega.Repository.IExperienciaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IExperienciaService {
    private final IExperienciaRepo IExperienciaRepo;

    @Autowired
    public IExperienciaService(IExperienciaRepo IExperienciaRepo) {
        this.IExperienciaRepo = IExperienciaRepo;
    }
    public Experiencia addExperience(Experiencia experiencia){
        return IExperienciaRepo.save(experiencia);
    }
    public List<Experiencia> findExperience(){
        return IExperienciaRepo.findAll();
    }
    public Experiencia editExperience(Experiencia experiencia){
        return IExperienciaRepo.save(experiencia);
    }
    public void deleteExperience(Long id){
        IExperienciaRepo.deleteById(id);
    }
}
