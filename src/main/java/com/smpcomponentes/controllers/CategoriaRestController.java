package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Categoria;
import com.smpcomponentes.models.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"localhost:4200"})
@RestController
@RequestMapping("/api")
public class CategoriaRestController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> index() {
        return categoriaService.findAll();
    }

    @GetMapping("/categorias/{id}")
    public Categoria show(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }

    @PostMapping("/categorias")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/categorias/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria, @PathVariable Integer id) {
        return categoriaService.save(categoria);
    }

    @DeleteMapping("/categorias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        categoriaService.delete(id);
    }
}
