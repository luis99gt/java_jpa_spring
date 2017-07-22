package com.example.javaJpa.clases;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by L99 on 7/21/2017.
 */

public class Persona {
    public String nombre;
    public String telefono;
    public String edad;

    public Persona() {
    }

    public Persona(String nombre, String telefono, String edad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}


