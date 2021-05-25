package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.LineaOrdenador;

import java.util.List;

public interface ILineaOrdenadorService {

    List<LineaOrdenador> findAll();

    List<LineaOrdenador> findByOrdenadorId(Integer ordenadorId);

    LineaOrdenador findById(Integer id);

    LineaOrdenador save(LineaOrdenador lineaOrdenador);

    void delete(Integer id);
}
