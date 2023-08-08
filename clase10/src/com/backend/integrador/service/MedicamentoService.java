package com.backend.integrador.service;

import com.backend.integrador.dao.IDao;
import com.backend.integrador.entity.Medicamento;

import java.util.List;

public class MedicamentoService {
    //capa de logica de negocio que interactua con la capa de persistencia, pero desconoce los detalles de la implementacion de esa persistencia
    private final IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento registrarMedicamento(Medicamento medicamento){
        return medicamentoIDao.registrar(medicamento);
    }
    public List<Medicamento> listarTodosLosMedicamentos() {
        return medicamentoIDao.listarTodos();
    }
    public Medicamento buscarMedicamentoPorId(int id){
        return medicamentoIDao.buscarPorId(id);
    }


}
