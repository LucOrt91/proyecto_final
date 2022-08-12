package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Proyecto;
import com.portfolio.Lucas.Ortega.Repository.RProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SProyecto {
        @Autowired
        RProyecto rProyecto;

        public List<Proyecto> list(){
            return rProyecto.findAll();
        }

        public Optional<Proyecto> getOne(int idPro){
            return rProyecto.findById(idPro);
        }

        public Optional<Proyecto> getByNombrePro(String nombrePro){
            return rProyecto.findByNombrePro(nombrePro);
        }

        public void save(Proyecto proyecto){
            rProyecto.save(proyecto);
        }

        public void delete(int idPro){
            rProyecto.deleteById(idPro);
        }

        public boolean existsById(int idPro){
            return rProyecto.existsById(idPro);
        }

        public boolean existsByNombrePro(String nombrePro){
            return rProyecto.existsByNombrePro(nombrePro);
        }
    }
