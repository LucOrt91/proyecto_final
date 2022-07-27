package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Educacion;
import com.portfolio.Lucas.Ortega.Repository.IEducacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.Lucas.Ortega.Repository.IEducacionRepo;

import java.util.List;

@Service
@Transactional
public class IEducacionService {
    private final IEducacionRepo IEducacionRepo;

    @Autowired
    public IEducacionService(IEducacionRepo IEducacionRepo) {
        this.IEducacionRepo = IEducacionRepo;
    }
    public Educacion addEducation(Educacion educacion){
        return IEducacionRepo.save(educacion);
    }
    public List<Educacion> findEducation(){
        return IEducacionRepo.findAll();
    }
    public Educacion editEducation(Educacion educacion){
        return IEducacionRepo.save(educacion);
    }
    public void deleteEducation (Long id){
        IEducacionRepo.deleteById(id);
    }

    public  getIEducacionRepo() {
        return IEducacionRepo;
    }
}
