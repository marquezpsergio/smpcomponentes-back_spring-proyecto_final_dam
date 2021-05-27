package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Usuario;
import com.smpcomponentes.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario show(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/usuarios/usuario/{user}")
    public ResponseEntity<?> showByUsuario(@PathVariable String user) {

        Usuario usuario;
        Map<String, Object> response = new HashMap<>();

        try {
            usuario = usuarioService.findByUsuario(user);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if (usuario == null) {
            response.put("mensaje", "El usuario '".concat(usuario.toString().concat("' no existe en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/usuarios/usuario-exist/{user}")
    public boolean existsByUsuario(@PathVariable String user) {
        return usuarioService.existsByUsuario(user);
    }

    @GetMapping("/usuarios/email-exist/{email}")
    public boolean existsByEmail(@PathVariable String email) {
        return usuarioService.existsByEmail(email);
    }


    @PostMapping("/usuarios")
    public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {

        Usuario usuarioNew;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream().map(
                    err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()
            ).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            usuarioNew = usuarioService.save(usuario);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear el usuario en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario ha sido creado con éxito!");
        response.put("usuario", usuarioNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Integer id) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        usuarioService.delete(id);
    }
}
