package com.portfolio.Lucas.Ortega.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPro;
    private String tituloPro;
    private String descPro;

    private String imgPro;

    public Project() {
    }

    public Project(long idPro, String tituloPro, String descExp, String imgExp) {
        this.idPro = idPro;
        this.tituloPro = tituloPro;
        this.descPro = descExp;
        this.imgPro = imgExp;
    }
}

