package com.smpcomponentes.security.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUsuario {

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, message = "debe tener al menos 4 caracteres")
    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 6, message = "debe tener al menos 6 caracteres")
    private String password;

    public LoginUsuario() {
    }

    public LoginUsuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
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
}
