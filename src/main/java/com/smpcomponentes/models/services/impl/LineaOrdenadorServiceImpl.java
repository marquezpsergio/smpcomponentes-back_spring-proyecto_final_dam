package com.smpcomponentes.models.services.impl;

import com.smpcomponentes.models.dao.ILineaOrdenadorDao;
import com.smpcomponentes.models.entity.LineaOrdenador;
import com.smpcomponentes.models.services.ILineaOrdenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LineaOrdenadorServiceImpl implements ILineaOrdenadorService {

    @Autowired
    private ILineaOrdenadorDao lineaOrdenadorDao;

    @Override
    @Transactional(readOnly = true)
    public List<LineaOrdenador> findAll() {
        return (List<LineaOrdenador>) lineaOrdenadorDao.findAll();
    }

    @Override
    public LineaOrdenador findById(Integer id) {
        return lineaOrdenadorDao.findById(id).orElse(null);
    }

    @Override
    public LineaOrdenador save(LineaOrdenador lineaOrdenador) {
        return lineaOrdenadorDao.save(lineaOrdenador);
    }

    @Override
    public void delete(Integer id) {
        lineaOrdenadorDao.deleteById(id);
    }
}
