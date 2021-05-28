package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM Usuarios u WHERE u.usuario = ?1", nativeQuery = true)
    Usuario findByUsuario(String usuario);

    @Query(value = "SELECT COUNT(u.id) FROM Usuarios u WHERE u.usuario = ?1", nativeQuery = true)
    Integer existsByUsuario(String usuario);

    @Query(value = "SELECT COUNT(u.id) FROM Usuarios u WHERE u.email = ?1", nativeQuery = true)
    Integer existsByEmail(String email);


}
