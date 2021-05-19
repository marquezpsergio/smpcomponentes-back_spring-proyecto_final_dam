package com.smpcomponentes.models.services.impl;

import com.smpcomponentes.models.dao.IComponenteDao;
import com.smpcomponentes.models.entity.Componente;
import com.smpcomponentes.models.services.IComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComponenteServiceImpl implements IComponenteService {

    @Autowired
    private IComponenteDao componenteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Componente> findAll() {
        return (List<Componente>) componenteDao.findAll();
    }

    @Override
    @Transactional
    public List<Componente> findByCategoriaId(Integer categoriaId) {
        return componenteDao.findByCategoriaId(categoriaId);
    }

    @Override
    @Transactional
    public List<Componente> findByFabricanteId(Integer fabricanteId) {
        return componenteDao.findByFabricanteId(fabricanteId);
    }

    @Override
    public Componente findById(Integer id) {
        return componenteDao.findById(id).orElse(null);
    }

    @Override
    public Componente save(Componente componente) {
        return componenteDao.save(componente);
    }

    @Override
    public void delete(Integer id) {
        componenteDao.deleteById(id);
    }
}
