package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.Rol;

import java.util.List;

public interface IRolService {

    List<Rol> findAll();

    Rol findById(Integer id);

    Rol save(Rol rol);

    void delete(Integer id);
}
