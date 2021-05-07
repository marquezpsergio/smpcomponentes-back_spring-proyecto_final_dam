package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
}
