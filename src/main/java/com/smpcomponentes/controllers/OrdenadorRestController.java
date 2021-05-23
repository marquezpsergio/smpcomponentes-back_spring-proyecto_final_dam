package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Ordenador;
import com.smpcomponentes.models.services.IOrdenadorService;
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
public class OrdenadorRestController {

    @Autowired
    private IOrdenadorService ordenadorService;

    @GetMapping("/ordenadores")
    public List<Ordenador> index() {
        return ordenadorService.findAll();
    }

    @GetMapping("/ordenadores/{id}")
    public Ordenador show(@PathVariable Integer id) {
        return ordenadorService.findById(id);
    }

    @PostMapping("/ordenadores")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Ordenador ordenador, BindingResult result) {

        Ordenador ordenadorNew;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream().map(
                    err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()
            ).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            ordenadorNew = ordenadorService.save(ordenador);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear el ordenador en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "EL ordenador ha sido creada con éxito!");
        response.put("ordenador", ordenadorNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/ordenadores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Ordenador update(@RequestBody Ordenador ordenador, @PathVariable Integer id) {
        return ordenadorService.save(ordenador);
    }

    @DeleteMapping("/ordenadores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        ordenadorService.delete(id);
    }
}
