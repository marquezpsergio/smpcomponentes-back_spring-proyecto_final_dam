package com.smpcomponentes.controllers;

import com.smpcomponentes.models.entity.Componente;
import com.smpcomponentes.models.services.IComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> show(@PathVariable Integer id) {

        Componente componente;
        Map<String, Object> response = new HashMap<>();

        try {
            componente = componenteService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if (componente == null) {
            response.put("mensaje", "El componente con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(componente, HttpStatus.OK);
    }

    @GetMapping("/componentes/categoria/{categoriaId}")
    public List<Componente> showCategoria(@PathVariable Integer categoriaId) {
        return componenteService.findByCategoriaId(categoriaId);
    }

    @GetMapping("/componentes/fabricante/{fabricanteId}")
    public List<Componente> showFabricante(@PathVariable Integer fabricanteId) {
        return componenteService.findByFabricanteId(fabricanteId);
    }

    @PostMapping("/componentes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Componente componente) {

        Componente componenteNew;
        Map<String, Object> response = new HashMap<>();

        try {
            componenteNew = componenteService.save(componente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El componente ha sido creado con éxito!");
        response.put("componente", componenteNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/componentes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody Componente componente, @PathVariable Integer id) {

        Componente componenteActual = componenteService.findById(id);

        Componente componenteUpd;
        Map<String, Object> response = new HashMap<>();

        if (componenteActual == null) {
            response.put("mensaje", "Error: No se pudo editar el cliente con ID '".concat(id.toString().concat("', no existe en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            componenteUpd = componenteService.save(componente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El componente ha sido actualizado con éxito!");
        response.put("componente", componenteUpd);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/componentes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
            componenteService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el componente de la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El componente ha sido eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
