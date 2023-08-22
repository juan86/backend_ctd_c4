package com.backend.clinicaodontologica.service;



import com.backend.clinicaodontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();

    Paciente registrarPaciente(Paciente paciente);

    Paciente buscarPacientePorId(int id);

    void eliminarPaciente(int id);

    Paciente modificarPaciente(Paciente pacienteModificado);



}
