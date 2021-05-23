package com.smpcomponentes.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "componentes")
public class Componente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 3, message = "debe tener al menos 3 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fabricante fabricante;

    @NotEmpty(message = "no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @NotEmpty(message = "no puede estar vacío")
    @Min(value = 0, message = "debe ser como mínimo 0")
    @Max(value = 99999, message = "debe ser como máximo 99999")
    private Double precio;

    @NotEmpty(message = "no puede estar vacío")
    private String imagen;

    @Min(value = 0, message = "debe ser como mínimo 0")
    @Max(value = 99999, message = "debe ser como máximo 99999")
    @Column(name = "unidades_disponibles")
    private Integer unidadesDisponibles;

    @NotEmpty(message = "no puede estar vacío")
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
