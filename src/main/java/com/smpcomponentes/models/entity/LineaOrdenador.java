package com.smpcomponentes.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "lineas_ordenadores")
public class LineaOrdenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ordenador ordenador;

    @NotEmpty(message = "no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER)
    private Componente componente;

    @NotEmpty(message = "no puede estar vacío")
    @Column(name = "precio_venta")
    private Double precioVenta;

    public LineaOrdenador() {
    }

    public LineaOrdenador(Integer id, Ordenador ordenador, Componente componente, Double precioVenta) {
        this.id = id;
        this.ordenador = ordenador;
        this.componente = componente;
        this.precioVenta = precioVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ordenador getOrdenador() {
        return ordenador;
    }

    public void setOrdenador(Ordenador ordenador) {
        this.ordenador = ordenador;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
