package com.example.helloworld.entity;

import java.io.Serializable;

public class Persona implements Serializable {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

}
