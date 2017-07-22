package com.example.javaJpa.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by L99 on 7/21/2017.
 */
@Entity
//public class Cliente extends Persona{
public class Cliente{
    public String nombre;
    public String telefono;
    public String edad;
    String dereccion;

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente() {
    }

//    public Cliente(String nombre, String telefono, String edad, String dereccion) {
//        super(nombre, telefono, edad);
//        this.dereccion = dereccion;
//    }

    public Cliente(String nombre, String telefono, String edad, String dereccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.dereccion = dereccion;
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

    public String getDereccion() {
        return dereccion;
    }

    public void setDereccion(String dereccion) {
        this.dereccion = dereccion;
    }
}
