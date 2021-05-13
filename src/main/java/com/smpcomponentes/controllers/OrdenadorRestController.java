package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Ordenador;
import com.smpcomponentes.models.services.IOrdenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Ordenador create(@RequestBody Ordenador ordenador) {
        return ordenadorService.save(ordenador);
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
