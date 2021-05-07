package com.smpcomponentes.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "componentes")
public class Componente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fabricante fabricante;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    private Double precio;

    private String imagen;

    @Column(name = "unidades_disponibles")
    private Integer unidadesDisponibles;

    private String url;

    public Componente() {
    }

    public Componente(String nombre, Fabricante fabricante, Categoria categoria, Double precio) {
        this.id = 0;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.categoria = categoria;
        this.precio = precio;
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(Integer unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String urlComponente) {
        this.url = urlComponente;
    }
}
