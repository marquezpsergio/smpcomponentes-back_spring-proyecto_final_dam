package com.smpcomponentes.models.services.impl;

import com.smpcomponentes.models.dao.IUsuarioDao;
import com.smpcomponentes.models.entity.Usuario;
import com.smpcomponentes.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsuario(String usuario) {
        return usuarioDao.findByUsuario(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUsuario(String usuario) {
        return usuarioDao.existsByUsuario(usuario) > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return usuarioDao.existsByEmail(email) > 0;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }
}
