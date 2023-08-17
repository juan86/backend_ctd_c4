package com.backend.digitalhouse.clase16.service;

import com.backend.digitalhouse.clase16.entity.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPacienteService {

    List<Paciente> listarTodosLosPacientes();
    Paciente buscarPorDni(int dni);

}
