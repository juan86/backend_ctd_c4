package com.backend.clinicaodontologica.service;



import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    Paciente buscarPacientePorId(int id);

    void eliminarPaciente(int id);

    Paciente modificarPaciente(Paciente pacienteModificado);



}
