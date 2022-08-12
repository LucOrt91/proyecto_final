package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Educacion;
import com.portfolio.Lucas.Ortega.Repository.REducacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SEducacion {
        @Autowired
        REducacion rEducacion;

        public List<Educacion> list(){
            return rEducacion.findAll();
        }

        public Optional<Educacion> getOne(int idEdu){
            return rEducacion.findById(idEdu);
        }

        public Optional<Educacion> getByNmbreEdu(String nombreEdu){
            return rEducacion.findByNombreEdu(nombreEdu);
        }

        public void save(Educacion educacion){
            rEducacion.save(educacion);
        }

        public void delete(int idEdu){
            rEducacion.deleteById(idEdu);
        }

        public boolean existsById(int idEdu){
            return rEducacion.existsById(idEdu);
        }

        public boolean existsByNombreEdu(String nombreEdu){
            return rEducacion.existsByNombreEdu(nombreEdu);
        }}
