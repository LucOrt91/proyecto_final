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
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPro;
    private String tituloPro;
    private String descPro;

    private String imgPro;

    public Proyecto() {
    }

    public Proyecto(long idPro, String tituloPro, String descExp, String imgExp) {
        this.idPro = idPro;
        this.tituloPro = tituloPro;
        this.descPro = descExp;
        this.imgPro = imgExp;
    }
}

