package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.LineaOrdenador;

import java.util.List;

public interface ILineaOrdenadorService {

    List<LineaOrdenador> findAll();

    LineaOrdenador findById(Integer id);

    LineaOrdenador save(LineaOrdenador lineaOrdenador);

    void delete(Integer id);
}
