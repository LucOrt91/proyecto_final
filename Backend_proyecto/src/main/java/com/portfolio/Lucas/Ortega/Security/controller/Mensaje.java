package com.portfolio.Lucas.Ortega.Security.controller;

public class Mensaje {
    private String mensaje;

    //Constructor

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    //Getter y Setter

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}