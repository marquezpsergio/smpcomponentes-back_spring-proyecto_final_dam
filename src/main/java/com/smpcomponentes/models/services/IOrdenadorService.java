package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.Ordenador;

import java.util.List;

public interface IOrdenadorService {

    List<Ordenador> findAll();

    Ordenador findById(Integer id);

    Ordenador save(Ordenador ordenador);

    void delete(Integer id);
}
