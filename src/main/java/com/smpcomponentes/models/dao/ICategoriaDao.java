package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaDao extends CrudRepository<Categoria, Integer> {
}
