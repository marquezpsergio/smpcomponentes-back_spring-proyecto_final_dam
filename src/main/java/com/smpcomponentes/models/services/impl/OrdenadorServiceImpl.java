package com.smpcomponentes.models.services.impl;

import com.smpcomponentes.models.dao.IOrdenadorDao;
import com.smpcomponentes.models.entity.Ordenador;
import com.smpcomponentes.models.services.IOrdenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenadorServiceImpl implements IOrdenadorService {

    @Autowired
    private IOrdenadorDao ordenadorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ordenador> findAll() {
        return (List<Ordenador>) ordenadorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ordenador> findAllLimit() {
        return ordenadorDao.findAllLimit();
    }

    @Override
    public Ordenador findById(Integer id) {
        return ordenadorDao.findById(id).orElse(null);
    }

    @Override
    public Ordenador save(Ordenador ordenador) {
        return ordenadorDao.save(ordenador);
    }

    @Override
    public void delete(Integer id) {
        ordenadorDao.deleteById(id);
    }


}
