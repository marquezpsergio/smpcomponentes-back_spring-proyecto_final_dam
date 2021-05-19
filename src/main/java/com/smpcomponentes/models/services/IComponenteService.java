package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.Componente;

import java.util.List;

public interface IComponenteService {

    List<Componente> findAll();

    List<Componente> findByCategoriaId(Integer categoriaId);

    List<Componente> findByFabricanteId(Integer categoriaId);

    Componente findById(Integer id);

    Componente save(Componente componente);

    void delete(Integer id);
}
