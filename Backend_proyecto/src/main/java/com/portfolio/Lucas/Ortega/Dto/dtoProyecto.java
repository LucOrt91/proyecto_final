package com.portfolio.Lucas.Ortega.Dto;

public class dtoProyecto {
    private String nombrePro;
    private String DescripcionPro;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombrePro, String descripcionPro) {
        this.nombrePro = nombrePro;
        DescripcionPro = descripcionPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return DescripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        DescripcionPro = descripcionPro;
    }
}
