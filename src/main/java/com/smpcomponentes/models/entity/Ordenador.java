package com.smpcomponentes.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenadores")
public class Ordenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @NotEmpty(message = "no puede estar vacío")
    @Min(value = 0, message = "debe ser como mínimo 0")
    @Max(value = 99999, message = "debe ser como máximo 99999")
    @Column(name = "precio_total")
    private Double precioTotal;

    @Column(name = "fecha_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @OneToMany(mappedBy = "ordenador")
    private List<LineaOrdenador> lineasOrdenador;

    public Ordenador() {
        lineasOrdenador = new ArrayList<>();
    }

    public Ordenador(Integer id, Usuario usuario, Double precioTotal) {
        lineasOrdenador = new ArrayList<>();
        this.id = id;
        this.usuario = usuario;
        this.precioTotal = precioTotal;
    }

    @PrePersist
    public void prePersist() {
        fechaCompra = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public List<LineaOrdenador> getLineasOrdenador() {
        return lineasOrdenador;
    }

    public void setLineasOrdenador(List<LineaOrdenador> lineasOrdenador) {
        this.lineasOrdenador = lineasOrdenador;
    }

    public void addLineaOrdenador(LineaOrdenador lineaOrdenador) {
        lineasOrdenador.add(lineaOrdenador);
    }

}
