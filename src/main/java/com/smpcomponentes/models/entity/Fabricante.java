package com.smpcomponentes.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fabricantes")
public class Fabricante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    public Fabricante() {
    }

    public Fabricante(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
