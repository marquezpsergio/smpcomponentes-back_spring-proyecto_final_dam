package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.Categoria;

import java.util.List;

public interface ICategoriaService {

    List<Categoria> findAll();

    Categoria findById(Integer id);

    Categoria save(Categoria categoria);

    void delete(Integer id);
}
