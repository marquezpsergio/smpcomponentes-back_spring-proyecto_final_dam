package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Ordenador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrdenadorDao extends CrudRepository<Ordenador, Integer> {

    @Query(value = "SELECT * FROM ordenadores ORDER BY fecha_compra DESC LIMIT 15", nativeQuery = true)
    List<Ordenador> findAllLimit();
}
