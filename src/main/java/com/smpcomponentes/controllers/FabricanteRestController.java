package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Fabricante;
import com.smpcomponentes.models.services.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FabricanteRestController {

    @Autowired
    private IFabricanteService fabricanteService;

    @GetMapping("/fabricantes")
    public List<Fabricante> index() {
        return fabricanteService.findAll();
    }

    @GetMapping("/fabricantes/{id}")
    public Fabricante show(@PathVariable Integer id) {
        return fabricanteService.findById(id);
    }

    @PostMapping("/fabricantes")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Fabricante create(@RequestBody Fabricante fabricante) {
        return fabricanteService.save(fabricante);
    }

    @PutMapping("/fabricantes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Fabricante update(@RequestBody Fabricante fabricante, @PathVariable Integer id) {
        return fabricanteService.save(fabricante);
    }

    @DeleteMapping("/fabricantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Integer id) {
        fabricanteService.delete(id);
    }
}
