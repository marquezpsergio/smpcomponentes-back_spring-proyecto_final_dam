package com.smpcomponentes.models.services;

import com.smpcomponentes.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> findAll();

    Usuario findById(Integer id);

    Usuario save(Usuario usuario);

    void delete(Integer id);

}
