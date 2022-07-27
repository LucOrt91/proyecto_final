package com.portfolio.Lucas.Ortega.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    private String tituloSkill;
    private String imgSkill;
    private int porcentaje;

    public Skill() {
    }

    public Skill(Long idSkill, String tituloSkill, String imgSkill, int porcentaje) {
        this.idSkill = idSkill;
        this.tituloSkill = tituloSkill;
        this.imgSkill = imgSkill;
        this.porcentaje = porcentaje;
    }
}
