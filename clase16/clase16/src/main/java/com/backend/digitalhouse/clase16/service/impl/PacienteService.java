package com.backend.digitalhouse.clase16.service.impl;

import com.backend.digitalhouse.clase16.dao.IDao;
import com.backend.digitalhouse.clase16.entity.Paciente;
import com.backend.digitalhouse.clase16.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private IDao<Paciente> pacienteIDao;

    @Autowired //no es necesario que la anotacion este
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }


    @Override
    public List<Paciente> listarTodosLosPacientes() {
        return pacienteIDao.listarTodos();
    }

    @Override
    public Paciente buscarPorDni(int dni) {
        return pacienteIDao.buscarPorCriterio(dni);
    }
}
