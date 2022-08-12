package com.portfolio.Lucas.Ortega.Service;

import com.portfolio.Lucas.Ortega.Entity.Skill;
import com.portfolio.Lucas.Ortega.Repository.RSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SSkill {
    @Autowired
    RSkill rSkill;

    public List<Skill> list(){
            return rSkill.findAll();
        }
        public Optional<Skill> getOne(int idSkill){
            return rSkill.findById(idSkill);
        }
        public Optional<Skill> getByNombreSkill(String nombreSkill){
            return rSkill.findByNombreSkill(nombreSkill);
        }
        public void save(Skill skill){
            rSkill.save(skill);
        }
        public void delete(int idSkill){
            rSkill.deleteById(idSkill);
        }
        public boolean existsById(int idSkill){
            return rSkill.existsById(idSkill);
        }
        public boolean existsByNombreSkill(String nombreSkill){
            return rSkill.existsByNombreSkill(nombreSkill);
        }
    }

