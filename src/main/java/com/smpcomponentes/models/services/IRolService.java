package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.Rol;

import java.util.List;

public interface IRolService {

    List<Rol> findAll();

    Rol findById(Integer id);

    Rol findByNombre(String nombre);

    Rol save(Rol rol);

    void delete(Integer id);
}
