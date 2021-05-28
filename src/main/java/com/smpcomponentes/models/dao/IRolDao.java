package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IRolDao extends CrudRepository<Rol, Integer> {

    @Query(value = "SELECT * FROM Roles r WHERE r.nombre = ?1", nativeQuery = true)
    Rol findByNombre(String nombre);

}
