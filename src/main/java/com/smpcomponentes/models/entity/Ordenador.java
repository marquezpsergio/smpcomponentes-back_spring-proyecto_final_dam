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

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @NotEmpty
    @Min(0)
    @Max(99999)
    @Column(name = "precio_total")
    private Double precioTotal;

    @Column(name = "fecha_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @OneToMany(mappedBy = "ordenador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LineaOrdenador> lineasOrdenadores;

    public Ordenador() {
        lineasOrdenadores = new ArrayList<>();
    }

    public Ordenador(Usuario usuario, Double precioTotal) {
        lineasOrdenadores = new ArrayList<>();
        this.id = 0;
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

    public List<LineaOrdenador> getLineasOrdenadores() {
        return lineasOrdenadores;
    }

    public void setLineasOrdenadores(List<LineaOrdenador> lineasOrdenadores) {
        this.lineasOrdenadores = lineasOrdenadores;
    }

    public void addLineaOrdenador(LineaOrdenador lineaOrdenador) {
        lineasOrdenadores.add(lineaOrdenador);
    }

}
