package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Ordenador;
import org.springframework.data.repository.CrudRepository;

public interface IOrdenadorDao extends CrudRepository<Ordenador, Integer> {
}
