package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.LineaOrdenador;
import com.smpcomponentes.models.services.ILineaOrdenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"localhost:4200"})
@RestController
@RequestMapping("/api")
public class LineaOrdenadorRestController {

    @Autowired
    private ILineaOrdenadorService lineaOrdenadorService;

    @GetMapping("/lineas_ordenadores")
    public List<LineaOrdenador> index() {
        return lineaOrdenadorService.findAll();
    }

    @GetMapping("/lineas_ordenadores/{id}")
    public LineaOrdenador show(@PathVariable Integer id) {
        return lineaOrdenadorService.findById(id);
    }

    @PostMapping("/lineas_ordenadores")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaOrdenador create(@RequestBody LineaOrdenador lineaOrdenador) {
        return lineaOrdenadorService.save(lineaOrdenador);
    }

    @PutMapping("/lineas_ordenadores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaOrdenador update(@RequestBody LineaOrdenador lineaOrdenador, @PathVariable Integer id) {
        return lineaOrdenadorService.save(lineaOrdenador);
    }

    @DeleteMapping("/lineas_ordenadores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        lineaOrdenadorService.delete(id);
    }
}
