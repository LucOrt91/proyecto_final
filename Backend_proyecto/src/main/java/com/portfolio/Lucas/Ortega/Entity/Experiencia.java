package com.portfolio.Lucas.Ortega.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idExp;
    private String tituloExp;
    private int fechaExp;
    private String descExp;

    private String imgExp;

    public Experiencia() {
    }

    public Experiencia(long idExp, String tituloExp, int fechaExp, String descExp, String imgEdu) {
        this.idExp = idExp;
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descExp = descExp;
        this.imgExp = imgExp;
    }
}
