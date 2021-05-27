package com.smpcomponentes.models.services.impl;

import com.smpcomponentes.models.dao.IRolDao;
import com.smpcomponentes.models.entity.Rol;
import com.smpcomponentes.models.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    public Rol findByNombre(String nombre) {
        return rolDao.findByNombre(nombre);
    }

    @Override
    public Rol save(Rol rol) {
        return rolDao.save(rol);
    }

    @Override
    public void delete(Integer id) {
        rolDao.deleteById(id);
    }
}
