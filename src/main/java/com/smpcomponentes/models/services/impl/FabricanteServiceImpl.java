package com.smpcomponentes.models.services.impl;

import com.smpcomponentes.models.dao.IFabricanteDao;
import com.smpcomponentes.models.entity.Fabricante;
import com.smpcomponentes.models.services.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FabricanteServiceImpl implements IFabricanteService {

    @Autowired
    private IFabricanteDao fabricanteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Fabricante> findAll() {
        return (List<Fabricante>) fabricanteDao.findAll();
    }

    @Override
    public Fabricante findById(Integer id) {
        return fabricanteDao.findById(id).orElse(null);
    }

    @Override
    public Fabricante save(Fabricante fabricante) {
        return fabricanteDao.save(fabricante);
    }

    @Override
    public void delete(Integer id) {
        fabricanteDao.deleteById(id);
    }
}
