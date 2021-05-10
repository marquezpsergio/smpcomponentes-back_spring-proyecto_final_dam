package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Componente;
import com.smpcomponentes.models.services.IComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ComponenteRestController {

    @Autowired
    private IComponenteService componenteService;

    @GetMapping("/componentes")
    public List<Componente> index() {
        return componenteService.findAll();
    }

    @GetMapping("/componentes/{id}")
    public Componente show(@PathVariable Integer id) {
        return componenteService.findById(id);
    }

    @GetMapping("/componentes/{categoriaId}")
    public List<Componente> showCategoria(@PathVariable Integer categoriaId) {
        return componenteService.findByCategoriaId(categoriaId);
    }

    @PostMapping("/componentes")
    @ResponseStatus(HttpStatus.CREATED)
    public Componente create(@RequestBody Componente componente) {
        return componenteService.save(componente);
    }

    @PutMapping("/componentes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Componente update(@RequestBody Componente componente, @PathVariable Integer id) {
        return componenteService.save(componente);
    }

    @DeleteMapping("/componentes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        componenteService.delete(id);
    }
}
