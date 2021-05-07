package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.Fabricante;

import java.util.List;

public interface IFabricanteService {

    List<Fabricante> findAll();

    Fabricante findById(Integer id);

    Fabricante save(Fabricante fabricante);

    void delete(Integer id);
}
