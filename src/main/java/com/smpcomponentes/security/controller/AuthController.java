package com.smpcomponentes.security.controller;

import com.smpcomponentes.models.entity.Usuario;
import com.smpcomponentes.models.services.IRolService;
import com.smpcomponentes.models.services.IUsuarioService;
import com.smpcomponentes.security.DTO.JwtDTO;
import com.smpcomponentes.security.DTO.LoginUsuario;
import com.smpcomponentes.security.DTO.NuevoUsuario;
import com.smpcomponentes.security.JWT.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IRolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity("Campos vacíos o email inválido", HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByUsuario(nuevoUsuario.getUsuario()))
            return new ResponseEntity("El usuario indicado ya existe", HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity("El email indicado ya existe", HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(nuevoUsuario.getEmail(), nuevoUsuario.getUsuario(),
                passwordEncoder.encode(nuevoUsuario.getPassword()));

        usuario.setRol(rolService.findByNombre("ROLE_USER"));
        usuarioService.save(usuario);
        return new ResponseEntity("Usuario creado con éxito!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity("Campos vacíos o email inválido", HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getUsuario(), loginUsuario.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDTO, HttpStatus.OK);
    }
}
