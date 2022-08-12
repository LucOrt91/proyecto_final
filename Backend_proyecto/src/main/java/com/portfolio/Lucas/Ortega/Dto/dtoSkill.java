package com.portfolio.Lucas.Ortega.Dto;

public class dtoSkill {
    private String nombreSkill;
    private String imagenSkill;
    private int nivelSkill;

    public dtoSkill() {
    }

    public dtoSkill(String nombreSkill, String imagenSkill, int nivelSkill) {
        this.nombreSkill = nombreSkill;
        this.imagenSkill = imagenSkill;
        this.nivelSkill = nivelSkill;
    }

    public String getNombreSkil() {
        return nombreSkill;
    }

    public void setNombreSkil(String nombreSkil) {
        nombreSkill = nombreSkil;
    }

    public String getImagenSkill() {
        return imagenSkill;
    }

    public void setImagenSkill(String imagenSkill) {
        this.imagenSkill = imagenSkill;
    }

    public int getNivelSkill() {
        return nivelSkill;
    }

    public void setNivelSkill(int nivelSkill) {
        this.nivelSkill = nivelSkill;
    }
}
