package com.portfolio.Lucas.Ortega.Dto;

public class dtoSkill {
    private String nombreSkill;
    private String imgSkill;
    private int nivelSkill;

    public dtoSkill() {
    }

    public dtoSkill(String nombreSkill, String imgSkill, int nivelSkill) {
        this.nombreSkill = nombreSkill;
        this.imgSkill = imgSkill;
        this.nivelSkill = nivelSkill;
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
