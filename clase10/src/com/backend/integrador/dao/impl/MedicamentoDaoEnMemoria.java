package com.backend.integrador.dao.impl;


import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Medicamento;
import org.apache.log4j.Logger;

import java.util.List;

public class MedicamentoDaoEnMemoria implements IDao<Medicamento> {

    private final Logger LOGGER = Logger.getLogger(MedicamentoDaoEnMemoria.class);
    private List<Medicamento> medicamentoRepository;

    public MedicamentoDaoEnMemoria(List<Medicamento> medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    public Medicamento registrar(Medicamento medicamento) {
        medicamentoRepository.add(medicamento);
        LOGGER.info("Medicamento guardado: " + medicamento);
        return medicamento;
    }

    @Override
    public List<Medicamento> listarTodos() {
        LOGGER.info("Listado de todos los medicamentos: \n" + medicamentoRepository);
        return medicamentoRepository;
    }
    @Override
    public Medicamento buscarPorId(int id) {
        Medicamento medicamentoBuscado = medicamentoRepository.get(id - 1);
        if (medicamentoBuscado != null)
            LOGGER.info("El medicamento de id " + id + " ha sido encontrado: " + medicamentoBuscado);
        else LOGGER.info("Medicamento no encontrado");
        return medicamentoBuscado;
    }
}
