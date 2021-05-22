package com.smpcomponentes.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lineas_ordenadores")
public class LineaOrdenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Ordenador ordenador;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Componente componente;

    @Column(name = "precio_venta")
    private Double precioVenta;

    public LineaOrdenador() {
    }

    public LineaOrdenador(Ordenador ordenador, Componente componente, Double precioVenta) {
        this.id = 0;
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
