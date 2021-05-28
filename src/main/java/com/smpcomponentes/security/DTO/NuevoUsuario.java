package com.smpcomponentes.security.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smpcomponentes.models.entity.Rol;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class NuevoUsuario {

    @NotEmpty(message = "no puede estar vacío")
    @Email(message = "no es una dirección de correo bien formada")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, message = "debe tener al menos 4 caracteres")
    @Column(nullable = false, unique = true)
    private String usuario;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 6, message = "debe tener al menos 6 caracteres")
    private String password;

    @JsonIgnore
    @NotEmpty(message = "no puede estar vacío")
    private Rol rol;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public NuevoUsuario() {
    }

    public NuevoUsuario(String email, String usuario, String password, Rol rol) {
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
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
