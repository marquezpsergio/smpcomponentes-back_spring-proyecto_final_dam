package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Ordenador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrdenadorDao extends CrudRepository<Ordenador, Integer> {

    @Query(value = "SELECT * FROM ordenadores o ORDER BY o.fecha_compra DESC LIMIT 15", nativeQuery = true)
    List<Ordenador> findAllLimit();

    @Query(value = "SELECT * FROM ordenadores o WHERE o.usuario_id = ?1 ORDER BY o.fecha_compra DESC LIMIT 15", nativeQuery = true)
    List<Ordenador> findByUsuarioId(Integer usuarioId);
}
