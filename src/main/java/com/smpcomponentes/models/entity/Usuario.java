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

    @NotEmpty(message = "no puede estar vacío")
    @Email(message = "no es una dirección de correo bien formada")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, message = "debe tener al menos 4 caracteres")
    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 6, message = "debe tener al menos 6 caracteres")
    private String password;

    @NotEmpty(message = "no puede estar vacío")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol rol;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public Usuario() {
    }

    public Usuario(String email, String nombreUsuario, String password) {
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public Usuario(String email, String nombreUsuario, String password, Rol rol) {
        this.email = email;
        this.nombreUsuario = nombreUsuario;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
