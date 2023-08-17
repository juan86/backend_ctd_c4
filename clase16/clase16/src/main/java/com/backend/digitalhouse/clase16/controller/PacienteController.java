package com.backend.digitalhouse.clase16.controller;

import com.backend.digitalhouse.clase16.entity.Paciente;
import com.backend.digitalhouse.clase16.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String buscarPacientePorDni(Model model, @RequestParam int dni){
        Paciente paciente = pacienteService.buscarPorDni(dni);

        //agregar los atributos al modelo que sera mostrado en la vista
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return "paciente";

    }

}
