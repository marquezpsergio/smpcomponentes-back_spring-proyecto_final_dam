package com.smpcomponentes.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Size(min = 4)
    @Column(nullable = false, unique = true)
    private String usuario;

    @NotEmpty
    @Size(min = 6)
    private String password;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Rol rol;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public Usuario() {
    }

    public Usuario(String email, String usuario, String password) {
        this.id = 0;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(String email, String usuario, String password, Rol rol) {
        this.id = 0;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    @PrePersist
    public void prePersist() {
        fechaRegistro = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
