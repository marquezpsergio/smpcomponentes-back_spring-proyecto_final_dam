package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuarios u WHERE u.nombre_usuario = ?1", nativeQuery = true)
    Usuario findByNombreUsuario(String nombreUsuario);

    @Query(value = "SELECT COUNT(u.id) FROM usuarios u WHERE u.nombre_usuario = ?1", nativeQuery = true)
    Integer existsByNombreUsuario(String nombreUsuario);

    @Query(value = "SELECT COUNT(u.id) FROM usuarios u WHERE u.email = ?1", nativeQuery = true)
    Integer existsByEmail(String email);


}
