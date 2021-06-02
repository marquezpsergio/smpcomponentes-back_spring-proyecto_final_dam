package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Fabricante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFabricanteDao extends CrudRepository<Fabricante, Integer> {
    @Query(value = "SELECT * FROM fabricantes fab where fab.id IN (SELECT comp.fabricante_id from componentes comp)", nativeQuery = true)
    List<Fabricante> findAllWithComponentes();
}
