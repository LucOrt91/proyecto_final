package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Projecto;
import com.portfolio.Lucas.Ortega.Entity.Proyecto;
import com.portfolio.Lucas.Ortega.Repository.IProyectoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProyectoService {
    private final IProyectoRepo IProyectoRepo;

    @Autowired
    public IProyectoService(IProyectoRepo IProyectoRepo) {
        this.IProyectoRepo = IProyectoRepo;
    }
    public Proyecto addProject(Proyecto proyecto){
        return IProyectoRepo.save(proyecto);
    }
    public List<Proyecto> findProject(){
        return IProyectoRepo.findAll();
    }
    public Proyecto editProject(Proyecto proyecto){
        return IProyectoRepo.save(proyecto);
    }
    public void deleteProject (Long id){
        IProyectoRepo.deleteById(id);
    }
}
