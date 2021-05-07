package com.smpcomponentes.models.dao;

import com.smpcomponentes.models.entity.Componente;
import org.springframework.data.repository.CrudRepository;

public interface IComponenteDao extends CrudRepository<Componente, Integer> {
}
