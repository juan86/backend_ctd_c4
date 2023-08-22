package com.backend.clinicaodontologica.controller;




import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //POST
    @PostMapping("registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }

    //PUT
    @PutMapping("actualizar")
    public Paciente actualizarPaciente(@RequestBody Paciente pacienteModificado){
        return pacienteService.modificarPaciente(pacienteModificado);
    }

}
