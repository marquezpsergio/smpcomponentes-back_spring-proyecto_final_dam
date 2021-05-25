package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.LineaOrdenador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILineaOrdenadorDao extends CrudRepository<LineaOrdenador, Integer> {

    @Query(value = "SELECT * FROM lineas_ordenadores lo WHERE lo.ordenador_id= ?1 ORDER BY lo.id", nativeQuery = true)
    List<LineaOrdenador> findByOrdenadorId(Integer ordenadorId);

}
