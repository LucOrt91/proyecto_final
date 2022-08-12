package com.portfolio.Lucas.Ortega.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPro;
    private String nombrePro;
    private String descripcionPro;

    public Proyecto() {
    }

    public Proyecto(String nombrePro, String descripcionPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }
}

