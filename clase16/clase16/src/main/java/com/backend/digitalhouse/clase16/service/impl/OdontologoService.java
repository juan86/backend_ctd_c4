package com.backend.digitalhouse.clase16.service.impl;

import com.backend.digitalhouse.clase16.dao.IDao;
import com.backend.digitalhouse.clase16.entity.Odontologo;
import com.backend.digitalhouse.clase16.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {

    private final IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarTodos();
    }

    @Override
    public Odontologo buscarPorMatricula(int matricula) {
        return odontologoIDao.buscarPorCriterio(matricula);
    }

}
