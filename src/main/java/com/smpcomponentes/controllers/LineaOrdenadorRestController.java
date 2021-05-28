package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.LineaOrdenador;
import com.smpcomponentes.models.services.ILineaOrdenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class LineaOrdenadorRestController {

    @Autowired
    private ILineaOrdenadorService lineaOrdenadorService;

    @GetMapping("/lineas-ordenadores")
    public List<LineaOrdenador> index() {
        return lineaOrdenadorService.findAll();
    }

    @GetMapping("/lineas-ordenadores/ordenador/{ordenadorId}")
    public List<LineaOrdenador> showLineasOrdenador(@PathVariable Integer ordenadorId) {
        return lineaOrdenadorService.findByOrdenadorId(ordenadorId);
    }

    @GetMapping("/lineas-ordenadores/{id}")
    public LineaOrdenador show(@PathVariable Integer id) {
        return lineaOrdenadorService.findById(id);
    }

    @PostMapping("/lineas-ordenadores")
    public ResponseEntity<?> create(@Valid @RequestBody LineaOrdenador lineaOrdenador, BindingResult result) {

        LineaOrdenador lineaOrdenadorNew;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream().map(
                    err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()
            ).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            lineaOrdenadorNew = lineaOrdenadorService.save(lineaOrdenador);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear la linea en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La linea de ordenador ha sido creada con éxito!");
        response.put("lineaOrdenador", lineaOrdenadorNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/lineas-ordenadores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public LineaOrdenador update(@RequestBody LineaOrdenador lineaOrdenador, @PathVariable Integer id) {

        return lineaOrdenadorService.save(lineaOrdenador);
    }

    @DeleteMapping("/lineas-ordenadores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Integer id) {
        lineaOrdenadorService.delete(id);
    }
}
