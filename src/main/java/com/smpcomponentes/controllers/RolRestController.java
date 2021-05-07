package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Rol;
import com.smpcomponentes.models.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"localhost:4200"})
@RestController
@RequestMapping("/api")
public class RolRestController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/roles")
    public List<Rol> index() {
        return rolService.findAll();
    }

    @GetMapping("/roles/{id}")
    public Rol show(@PathVariable Integer id) {
        return rolService.findById(id);
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol create(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @PutMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol update(@RequestBody Rol rol, @PathVariable Integer id) {
        return rolService.save(rol);
    }

    @DeleteMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        rolService.delete(id);
    }
}
