package com.portfolio.Lucas.Ortega.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSkill;
    private String nombreSkill;
    private String imgSkill;

    private int nivelSkill;


    public Skill() {
    }

    public Skill(String tituloSkill, String imgSkill, int nivelSkill) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
        this.nivelSkill = nivelSkill;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }

    public int getNivelSkill() {
        return nivelSkill;
    }

    public void setNivelSkill(int nivelSkill) {
        this.nivelSkill = nivelSkill;
    }
}
