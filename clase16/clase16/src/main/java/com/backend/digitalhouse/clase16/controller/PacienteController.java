package com.backend.digitalhouse.clase16.controller;

import com.backend.digitalhouse.clase16.entity.Paciente;
import com.backend.digitalhouse.clase16.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
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

    //ejemplo de endpoint rest con PathVariable - http://localhost:8081/pacientes/11111111
    @GetMapping("/{dni}")
    public Paciente buscarPacPorDni(@PathVariable int dni){
        return pacienteService.buscarPorDni(dni);
    }

    //mismo ejemplo con RequestParam - http://localhost:8081/pacientes/buscar?dni=11111111
    @GetMapping("/buscar")
    public Paciente buscarPorDni(@RequestParam int dni){
        return pacienteService.buscarPorDni(dni);
    }

}
