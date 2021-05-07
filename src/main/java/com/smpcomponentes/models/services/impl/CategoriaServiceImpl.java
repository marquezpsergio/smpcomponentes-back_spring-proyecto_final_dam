package com.smpcomponentes.models.services.impl;

import com.smpcomponentes.models.dao.ICategoriaDao;
import com.smpcomponentes.models.entity.Categoria;
import com.smpcomponentes.models.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private ICategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Override
    public Categoria findById(Integer id) {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    public void delete(Integer id) {
        categoriaDao.deleteById(id);
    }
}
